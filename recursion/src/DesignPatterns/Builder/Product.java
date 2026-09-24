package DesignPatterns.Builder;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private final Long id;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isVariant() {
        return isVariant;
    }

    public List<String> getBullets() {
        return bullets;
    }

    private final String name;
    private final String title;
    private final String description;
    private final boolean isVariant;
    private final List<String> bullets;

    public Product(Builder builder){
        this.id= builder.id;
        this.name= builder.name;
        this.title=builder.title;
        this.description=builder.description;
        this.isVariant= builder.isVariant;;
        this.bullets=builder.bullets;

    }

    public static class Builder{
        private Long id;
        private String name;
        private String title;
        private String description;
        private boolean isVariant;
        private List<String> bullets;

        public Builder addId(Long id){
            this.id=id;
            return this;
        }

        public Builder addName(String name){
            this.name=name;
            return this;
        }

        public Builder addTitle(String title){
            this.title=title;
            return this;
        }

        public Builder addDescription(String desc){
            this.description=desc;
            return this;

        }

        public Builder isVariant(Boolean flag){
            this.isVariant=flag;
            return  this;
        }

        public Builder addBullets(List<String> bullets){
            this.bullets=new ArrayList<>(bullets);
            return this;
        }

        public Product build(){
            return new Product(this);
        }



    }
}
