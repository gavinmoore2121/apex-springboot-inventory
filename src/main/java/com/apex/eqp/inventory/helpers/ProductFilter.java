package com.apex.eqp.inventory.helpers;

import com.apex.eqp.inventory.entities.Product;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductFilter {

    private final Set<String> recalledProductNames;

    public ProductFilter(Set<String> recalledProductNames) {
        this.recalledProductNames = recalledProductNames;
    }

    public List<Product> removeRecalledFrom(Collection<Product> allProduct) {
        return allProduct.stream()
                .filter(this::filterByName)
                .collect(Collectors.toList());
    }

    private boolean filterByName(Product product) {
        return !recalledProductNames.contains(product.getName());
    }
}
