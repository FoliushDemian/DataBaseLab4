package org.example.view;

import org.example.controller.*;
import org.example.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MyView {
    @Autowired
    private CategoryController categoryController;

    @Autowired
    private CustomerController customerController;

    @Autowired
    private GoodsController goodsController;

    @Autowired
    private ShopController shopController;

    @Autowired
    private SubCategoryController subCategoryController;

    final Map<String, String> menu;
    final Map<String, Printable> methodsMenu;
    final Scanner input = new Scanner(System.in);
    final Category nullCategory = new Category(null, null);
    final Customer nullCustomer = new Customer(null, null, null, null);
    final Goods nullGoods = new Goods(null, null, null, null, null);
    final Shop nullShop = new Shop(null, null, null);
    final SubCategory nullSubCategory = new SubCategory(null, null, null);

    public MyView() {
        menu = new LinkedHashMap<>();

        menu.put("A", "  A - Select all table");

        menu.put("1", "   1 - Table: Category");
        menu.put("11", "  11 - Create Category");
        menu.put("12", "  12 - Update Category");
        menu.put("13", "  13 - Delete from Category");
        menu.put("14", "  14 - Find all Categories");
        menu.put("15", "  15 - Find Category by ID");
        menu.put("16", "  16 - Find Category by name");

        menu.put("2", "   2 - Table: Customer");
        menu.put("21", "  21 - Create Customer");
        menu.put("22", "  22 - Update Customer");
        menu.put("23", "  23 - Delete from Customer");
        menu.put("24", "  24 - Find all Customers");
        menu.put("25", "  25 - Find Customer by ID");
        menu.put("26", "  26 - Find Customer by name");
        menu.put("27", "  27 - Find Customer by email");

        menu.put("3", "   3 - Table: Goods");
        menu.put("31", "  31 - Create Goods");
        menu.put("32", "  32 - Update Goods");
        menu.put("33", "  33 - Delete from Goods");
        menu.put("34", "  34 - Find all Goods");
        menu.put("35", "  35 - Find Goods by ID");

        menu.put("4", "   4 - Table: Shop");
        menu.put("41", "  41 - Create Shop");
        menu.put("42", "  42 - Update Shop");
        menu.put("43", "  43 - Delete from Shop");
        menu.put("44", "  44 - Find all Shops");
        menu.put("45", "  45 - Find Shop by ID");
        menu.put("46", "  46 - Find Shop by name");
        menu.put("47", "  47 - Find all Goods of Shop by ShopID");

        menu.put("5", "   5 - Table: SubCategory");
        menu.put("51", "  51 - Create SubCategory");
        menu.put("52", "  52 - Update SubCategory");
        menu.put("53", "  53 - Delete from SubCategory");
        menu.put("54", "  54 - Find all SubCategories");
        menu.put("55", "  55 - Find SubCategory by ID");
        menu.put("56", "  56 - Find SubCategory by name");

        menu.put("Q", "  Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("A", this::selectAllTable);

        methodsMenu.put("11", this::createCategory);
        methodsMenu.put("12", this::updateCategory);
        methodsMenu.put("13", this::deleteFromCategory);
        methodsMenu.put("14", this::findAllCategories);
        methodsMenu.put("15", this::findCategoryById);
        methodsMenu.put("16", this::findCategoryByCategoryName);

        methodsMenu.put("21", this::createCustomer);
        methodsMenu.put("22", this::updateCustomer);
        methodsMenu.put("23", this::deleteFromCustomer);
        methodsMenu.put("24", this::findAllCustomers);
        methodsMenu.put("25", this::findCustomerById);
        methodsMenu.put("26", this::findCustomerByName);
        methodsMenu.put("27", this::findCustomerByEmail);

        methodsMenu.put("31", this::createGoods);
        methodsMenu.put("32", this::updateGoods);
        methodsMenu.put("33", this::deleteFromGoods);
        methodsMenu.put("34", this::findAllGoods);
        methodsMenu.put("35", this::findGoodsById);

        methodsMenu.put("41", this::createShop);
        methodsMenu.put("42", this::updateShop);
        methodsMenu.put("43", this::deleteFromShop);
        methodsMenu.put("44", this::findAllShops);
        methodsMenu.put("45", this::findShopById);
        methodsMenu.put("46", this::findShopByShopName);
        methodsMenu.put("47", this::findAllGoodsByShopId);

        methodsMenu.put("51", this::createSubCategory);
        methodsMenu.put("52", this::updateSubCategory);
        methodsMenu.put("53", this::deleteFromSubCategory);
        methodsMenu.put("54", this::findAllSubCategory);
        methodsMenu.put("55", this::findSubCategoryById);
        methodsMenu.put("56", this::findSubCategoryBySubCategoryName);
    }

    private void selectAllTable() {
        findAllCategories();
        findAllCustomers();
        findAllGoods();
        findAllShops();
        findAllSubCategory();
    }

    // region CATEGORY ---------------------------------------------------
    private void createCategory() {
        System.out.println("Input 'category name': ");
        String name = input.nextLine();
        Category category = new Category(null, name);

        int count = categoryController.create(category);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateCategory() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'name': ");
        String name = input.nextLine();
        Category category = new Category(null, name);

        int count = categoryController.update(id, category);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromCategory() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = categoryController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllCategories() {
        System.out.println("\nTable: CATEGORY");
        List<Category> categories = categoryController.findAll();
        for (Category category : categories) {
            System.out.println(category);
        }
    }

    private void findCategoryById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Category> category = categoryController.findById(id);
        System.out.println(category.orElse(nullCategory));
    }

    private void findCategoryByCategoryName() {
        System.out.println("Input 'category name': ");
        String name = input.nextLine();

        Optional<Category> category = categoryController.findByCategoryName(name);
        System.out.println(category.orElse(nullCategory));
    }

    //endregion CATEGORY


    // region CUSTOMER ------------------------------------------
    private void createCustomer() {
        System.out.println("Input 'customer name': ");
        String name = input.nextLine();
        System.out.println("Input 'customer email': ");
        String email = input.nextLine();
        System.out.println("Input 'customer phoneNumber': ");
        String phoneNumber = input.nextLine();

        Customer customer = new Customer(null, name, email, phoneNumber);

        int count = customerController.create(customer);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateCustomer() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'customer new name': ");
        String name = input.nextLine();

        System.out.println("Input 'customer new email': ");
        String email = input.nextLine();

        System.out.println("Input 'customer new phoneNumber': ");
        String phoneNumber = input.nextLine();

        Customer customer = new Customer(null, name, email, phoneNumber);

        int count = customerController.update(id, customer);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromCustomer() {
        System.out.println("Input 'customer id': ");
        Integer id = Integer.valueOf(input.nextLine());

        int count = customerController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllCustomers() {
        System.out.println("\nTable: CUSTOMER");
        List<Customer> customers = customerController.findAll();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private void findCustomerById() {
        System.out.println("Input 'Customer id': ");
        Integer id = Integer.valueOf(input.nextLine());

        Optional<Customer> customer = customerController.findById(id);
        System.out.println(customer.orElse(nullCustomer));
    }

    private void findCustomerByName() {
        System.out.println("Input 'Customer name': ");
        String name = input.nextLine();

        Optional<Customer> customer = customerController.findByCustomerName(name);
        System.out.println(customer.orElse(nullCustomer));
    }

    private void findCustomerByEmail() {
        System.out.println("Input 'Customer email': ");
        String email = input.nextLine();

        Optional<Customer> customer = customerController.findByCustomerEmail(email);
        System.out.println(customer.orElse(nullCustomer));
    }
    //endregion CUSTOMER


    // region GOODS -------------------------------------------------
    private void createGoods() {
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'price': ");
        String price = input.nextLine();
        System.out.println("Input 'expirationDate': ");
        String expirationDate = input.nextLine();
        System.out.println("Input 'customerId': ");
        Integer customerId = Integer.valueOf(input.nextLine());


        Goods goods = new Goods(null, name, price,
                expirationDate, customerId);

        int count = goodsController.create(goods);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateGoods() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'price': ");
        String price = input.nextLine();
        System.out.println("Input 'expirationDate': ");
        String expirationDate = input.nextLine();
        System.out.println("Input 'customerId': ");
        Integer customerId = Integer.valueOf((input.nextLine()));


        Goods goods = new Goods(null, name, price, expirationDate, customerId);

        int count = goodsController.update(id, goods);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromGoods() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = goodsController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllGoods() {
        System.out.println("\nTable: GOODS");
        List<Goods> goodPlural = goodsController.findAll();
        for (Goods goods : goodPlural) {
            System.out.println(goods);
        }
    }

    private void findGoodsById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Goods> goods = goodsController.findById(id);
        System.out.println(goods.orElse(nullGoods));
    }
    //endregion GOODS


    // region SHOP
    private void createShop() {
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'minOrderAmount': ");
        Integer minOrderAmount = Integer.valueOf(input.nextLine());

        Shop shop = new Shop(null, name, minOrderAmount);

        int count = shopController.create(shop);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateShop() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'minOrderAmount': ");
        Integer minOrderAmount = Integer.valueOf(input.nextLine());

        Shop shop = new Shop(null, name, minOrderAmount);


        int count = shopController.update(id, shop);
        System.out.printf("There are created %d rows\n", count);
    }

    private void deleteFromShop() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = shopController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllShops() {
        System.out.println("\nTable: SHOP");
        List<Shop> shops = shopController.findAll();
        for (Shop shop : shops) {
            System.out.println(shop);
        }
    }

    private void findShopById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Shop> shop = shopController.findById(id);
        System.out.println(shop.orElse(nullShop));
    }

    private void findShopByShopName() {
        System.out.println("Input 'Shop name': ");
        String name = input.nextLine();

        Optional<Shop> shop = shopController.findByShopName(name);
        System.out.println(shop.orElse(nullShop));
    }

    private void findAllGoodsByShopId() {
        System.out.println("Input 'SHOP id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        List<Goods> goodss = shopController.findAllGoodsBy(id);
        for (Goods goods : goodss) {
            System.out.println(goods);
        }
    }
    // endregion SHOP

    //region SUBCATEGORY
    private void createSubCategory() {
        System.out.println("Input 'SubCategory name': ");
        String name = input.nextLine();
        System.out.println("Input 'SubCategory categoryId': ");
        Integer categoryId = Integer.valueOf(input.nextLine());


        SubCategory subCategory = new SubCategory(null, name, categoryId);

        int count = subCategoryController.create(subCategory);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateSubCategory() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'categoryId': ");
        Integer categoryId = Integer.valueOf(input.nextLine());

        SubCategory subCategory = new SubCategory(null, name, categoryId);


        int count = subCategoryController.update(id, subCategory);
        System.out.printf("There are created %d rows\n", count);
    }

    private void deleteFromSubCategory() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = subCategoryController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findSubCategoryById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<SubCategory> subCategory = subCategoryController.findById(id);
        System.out.println(subCategory.orElse(nullSubCategory));
    }

    private void findSubCategoryBySubCategoryName() {
        System.out.println("Input 'SubCategory name': ");
        String name = input.nextLine();

        Optional<SubCategory> subCategory = subCategoryController.findBySubCategoryName(name);
        System.out.println(subCategory.orElse(nullSubCategory));
    }

    private void findAllSubCategory() {
        System.out.println("\nTable: SUBCATEGORY");
        List<SubCategory> subCategories = subCategoryController.findAll();
        for (SubCategory subCategory : subCategories) {
            System.out.println(subCategory);
        }
    }
        // endregion SUBCATEGORY

        //-------------------------------------------------------------------------

        // region output
        private void outputMenu () {
            System.out.println("\nMENU:");
            for (String key : menu.keySet())
                if (key.length() == 1) System.out.println(menu.get(key));
        }

        private void outputSubMenu (String fig){
            System.out.println("\nSubMENU:");
            for (String key : menu.keySet())
                if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
        }

        public void show () {
            String keyMenu;
            do {
                outputMenu();
                System.out.println("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();

                if (keyMenu.matches("^\\d")) {
                    outputSubMenu(keyMenu);
                    System.out.println("Please, select menu point.");
                    keyMenu = input.nextLine().toUpperCase();
                }

                try {
                    methodsMenu.get(keyMenu).print();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } while (!keyMenu.equals("Q"));
        }
}
