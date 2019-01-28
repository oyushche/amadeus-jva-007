package com.amadeus.birds;

import java.util.*;

public class Purchase {
    private ArrayList<Order> orders;

    private Warehouse warehouse;

    private class Order {
        private String by;

        private Integer productId;

        private Integer amount;

        public String getBy() {
            return by;
        }

        public Order setBy(String by) {
            this.by = by;

            return this;
        }

        public Integer getProductId() {
            return productId;
        }

        public Order setProductId(Integer productId) {
            this.productId = productId;

            return this;
        }

        public Integer getAmount() {
            return amount;
        }

        public Order setAmount(Integer amount) {
            this.amount = amount;

            return this;
        }
    }

    private class UserOrders {
        private Integer number;

        private Double total;

        private String customer;

        public String getCustomer() {
            return customer;
        }

        public UserOrders setCustomer(String customer) {
            this.customer = customer;

            return this;
        }

        public Integer getNumber() {
            return number;
        }

        public UserOrders setNumber(Integer number) {
            this.number = number;

            return this;
        }

        public Double getTotal() {
            return total;
        }

        public UserOrders setTotal(Double total) {
            this.total = total;

            return this;
        }
    }

    Purchase(Warehouse warehouse) {
        this.warehouse = warehouse;
        this.orders = new ArrayList<>();
    }

    public Boolean make(Integer productId, Integer amount, String by) {
        if (!this.warehouse.shipAmountByWareId(productId, amount)) {
            return false;
        }

        this.orders.add((new Order()).setProductId(productId).setAmount(amount).setBy(by));

        return true;
    }

    public Double getProfit() {
        Double profit = 0.0;
        Integer i = 0;

        for (Order o: this.orders) {
            profit += this.getOrderTotal(i);

            i++;
        }

        return profit;
    }

    private Double getOrderTotal(Integer orderId) {
        try {
            Order order = this.orders.get(orderId);

            return this.warehouse.getPriceByWareId(order.getProductId()) * order.getAmount();
        } catch (Throwable t) {
            return 0.0;
        }
    }

    public Integer getAmountSoldByProductId(Integer productId) {
        Integer amount = 0;

        for (Order o: this.orders) {
            if (o.getProductId().equals(productId)) {
                amount += o.getAmount();
            }
        }

        return amount;
    }

    public Double getProfitByProductId(Integer productId) {
        Double profit = 0.0;
        Integer i = 0;

        for (Order o: this.orders) {
            if (o.getProductId().equals(productId)) {
                profit += this.getOrderTotal(i);
            }

            i++;
        }

        return profit;
    }

    public HashMap<String, UserOrders> groupByCustomer() {
        HashMap<String, UserOrders> stats = new HashMap<>();
        Integer i = 0;

        for (Order o: this.orders) {
            UserOrders uo;
            Double orderTotal = this.getOrderTotal(i);

            if (stats.containsKey(o.getBy())) {
                uo = stats.get(o.getBy());

                uo.setNumber(uo.getNumber() + 1);
                uo.setTotal(uo.getTotal() + orderTotal);
            } else {
                uo = new UserOrders();
                uo.setCustomer(o.getBy()).setNumber(1).setTotal(orderTotal);
            }

            stats.put(o.getBy(), uo);

            i++;
        }

        return stats;
    }

    public String getCustomersBySpentMoney() {
        String result = "";
        HashMap<String, UserOrders> stats = this.groupByCustomer();
        List<UserOrders> orders = new ArrayList<>(stats.values());

        Collections.sort(orders, Comparator.comparing(UserOrders::getTotal));

        for (UserOrders uo: orders) {
            result += uo.getCustomer() + " " + uo.getTotal().toString() + "$\n";
        }

        return result;
    }

    public String getCustomersByOrdersNumber() {
        String result = "";
        HashMap<String, UserOrders> stats = this.groupByCustomer();
        List<UserOrders> orders = new ArrayList<>(stats.values());

        Collections.sort(orders, Comparator.comparing(UserOrders::getNumber));

        for (UserOrders uo: orders) {
            result += uo.getCustomer() + " " + uo.getNumber().toString() + "\n";
        }

        return result;
    }
}
