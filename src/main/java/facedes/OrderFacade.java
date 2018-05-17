//package facedes;
//
//import java.util.ArrayList;
//
//public class OrderFacade {
//	
//	private UserDao userDao;
//	private TourDao tourDao;
//	private OrderDao orderDao;
//	
//	
//	public List<OrderData> getOrdersData() {
//		List<Order> orders = orderDao.getOrders();
//		List<OrderData> resultList = new ArrayList<>();
//		for (Order order : orders) {
//			OrderData od = new OrderData();
//			od.setUser(userDao.findUserById(order.getUserId()));
//			od.setTour(tourDao.findTourById(order.getTourId()));
//			od.setOrderDate(order.getOrderDate());
//			resultList.add(od);
//		}
//		return resultList;
//	}
//
//}


