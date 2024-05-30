package com.kodilla.good.patterns.challenges;

public class ProductOrderService {
    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public ProductOrderService(final InformationService informationService,
                               final OrderService orderService,
                               final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest.getUser(), orderRequest.getProduct());
        if (isOrdered) {
            informationService.inform(orderRequest.getUser());
            orderRepository.createOrder(orderRequest.getUser(), orderRequest.getProduct());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }

    public static void main(String[] args) {
        User user = new User("Joe Black", "joe_black@gmail.com");
        Product product = new Product("|" +"Jenga"+ "|");

        InformationService informationService = new EmailService();
        OrderService orderService = new ProductOrderServiceImplementation();
        OrderRepository orderRepository = new OrderRepositoryImplementation();

        ProductOrderService productOrderService = new ProductOrderService(informationService, orderService, orderRepository);
        OrderRequest orderRequest = new OrderRequest(user, product);

        OrderDto orderDto = productOrderService.process(orderRequest);

        System.out.println("Order status: " + (orderDto.isOrdered() ? "Success" : "Failed"));
    }
}
