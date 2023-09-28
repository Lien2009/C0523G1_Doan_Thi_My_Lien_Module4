package com.example.exercise.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> productMap = new HashMap<>();

    public CartDto() {
    }
    public void addProduct(ProductDto productDto){
        if(productMap.containsKey(productDto)){
            int currentValue = productMap.get(productDto);
            productMap.replace(productDto,currentValue+1);
        }else {
            productMap.put(productDto,1);
        }
    }
    public void minusProductQuantity(ProductDto productDto){
        int currentValue = productMap.get(productDto);
        productMap.replace(productDto,currentValue-1);
    }
    public void deleteProduct(ProductDto productDto){
        productMap.remove(productDto);
    }
    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }
}
