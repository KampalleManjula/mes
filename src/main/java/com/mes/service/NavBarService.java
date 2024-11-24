package com.mes.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.model.DropChild;
import com.mes.model.DropChildOfChild;
import com.mes.model.DropdownItem;
import com.mes.model.GrandChild;
import com.mes.model.NavLink;
import com.mes.repository.DropChildOfChildRepository;
import com.mes.repository.DropChildRepository;
import com.mes.repository.DropdownItemRepository;
import com.mes.repository.GrandChildRepository;
import com.mes.repository.NavLinkRepository;


@Service
public class NavBarService {

	@Autowired
    private NavLinkRepository navLinkRepository;

    @Autowired
    private DropdownItemRepository dropdownItemRepository;

    @Autowired
    private DropChildRepository dropChildRepository;

    @Autowired
    private DropChildOfChildRepository dropChildOfChildRepository;

    @Autowired
    private GrandChildRepository grandChildRepository;

    public List<NavLink> getAllNavLinks() {
        return navLinkRepository.findAll();
    }

    public List<DropdownItem> getDropdownItemsByNavbarItemId(Long navbarItemId) {
        return dropdownItemRepository.findByNavLinkId(navbarItemId);
    }

    public List<DropChild> getDropChildrenByDropdownItemId(Long dropdownItemId) {
        return dropChildRepository.findByDropdownItemId(dropdownItemId);
    }

    public List<DropChildOfChild> getDropChildrenOfChildByDropChildId(Long dropChildId) {
        return dropChildOfChildRepository.findByDropChildId(dropChildId);
    }

    public List<GrandChild> getGrandChildrenByDropChildOfChildId(Long dropChildOfChildId) {
        return grandChildRepository.findByDropChildOfChildId(dropChildOfChildId);
    }

   
    public Map<NavLink, List<DropdownItem>> getNavbarWithDropdownData() {
        List<NavLink> navbarItems = navLinkRepository.findAll();
        Map<NavLink, List<DropdownItem>> dropdownData = new LinkedHashMap<>();

        for (NavLink navbarItem : navbarItems) {
            List<DropdownItem> dropdownItems = dropdownItemRepository.findByNavLinkId(navbarItem.getId());
            
            // Iterate over dropdown items and set DropChildren
            for (DropdownItem dropdownItem : dropdownItems) {
                List<DropChild> dropChildren = dropChildRepository.findByDropdownItemId(dropdownItem.getId());
                
                // Iterate over DropChild items and set DropChildrenOfChild
                for (DropChild dropChild : dropChildren) {
                    List<DropChildOfChild> dropChildrenOfChild = dropChildOfChildRepository.findByDropChildId(dropChild.getId());
                    
                    // Iterate over DropChildOfChild items and set GrandChildren
                    for (DropChildOfChild dropChildOfChild : dropChildrenOfChild) {
                        List<GrandChild> grandChildren = grandChildRepository.findByDropChildOfChildId(dropChildOfChild.getId());
                        dropChildOfChild.setGrandChildren(grandChildren);
                    }
                    
                    dropChild.setDropChildrenOfChild(dropChildrenOfChild);
                }
                
                dropdownItem.setDropChildren(dropChildren);
            }
            
            dropdownData.put(navbarItem, dropdownItems);
        }

        return dropdownData;
    }
    
}
