package com.example.demo.purchases.values;

import co.com.sofka.domain.generic.Identity;

public class PurchasingBookId extends Identity{
        public PurchasingBookId(){
        }
        private PurchasingBookId(String uid){
            super(uid);
        }
        public static PurchasingBookId of(String uid){
            return new PurchasingBookId(uid);
        }
}
