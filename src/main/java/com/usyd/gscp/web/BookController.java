package com.usyd.gscp.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usyd.gscp.domain.User;
import com.usyd.gscp.domain.Book;
import com.usyd.gscp.domain.Orders;
import com.usyd.gscp.service.UserService;
import com.usyd.gscp.service.BookService;
import com.usyd.gscp.service.OrdersService;

@Controller
@SessionAttributes("current_user")
public class BookController{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private OrdersService orderService;
	
	@RequestMapping(value = "/trading/home", method = RequestMethod.GET)
	public String welcome(Locale locale, Model model,
			@ModelAttribute("current_user") User user) {
		
		model.addAttribute("current_user", user);
		
		return "trading-home";
	}
	
	@RequestMapping(value = "/trading/repository", method = RequestMethod.GET)
	public String listMyRepository(Locale locale, Model model,
			@ModelAttribute("current_user") User user) {
		ArrayList<Book> books = bookService.getBookByOwnerId(user.getId());
		
		Collections.sort(books, new Comparator<Book>(){
			@Override
			public int compare(Book book1, Book book2)
			{
				int result = -1;
				if(book1.getId() < book2.getId()){
					result = 1;
				}
				return result;
			}
		});
		
		model.addAttribute("current_user", user);
		model.addAttribute("books", books);
		model.addAttribute("type", "view");
		
		return "trading-repository";
	}
	
	@RequestMapping(value = "/trading/new_post", method = RequestMethod.GET)
	public String newTopicForm(Locale locale, Model model,
			@ModelAttribute("current_user") User user) {
		
		model.addAttribute("current_user", user);
		
		return "trading-new-post";
	}

	@RequestMapping(value = "/trading/new_post", method = RequestMethod.POST)
	public String createNewPost(Locale locale, Model model,
			@ModelAttribute("current_user") User user,
			@RequestParam("title") String title,
			@RequestParam("edition") String edition,
			@RequestParam("author") String author,
			@RequestParam("year") String year,
			@RequestParam("subject") String subject,
			@RequestParam("price") String price) 
	{
		
		Book newBook = new Book();
		
		newBook.setOwner(user.getId());
		newBook.setAuthor(author);
		newBook.setEdition(Integer.parseInt(edition));
		newBook.setPrice(Integer.parseInt(price));
		newBook.setStatus("Post");
		newBook.setSubject(subject);
		newBook.setTitle(title);
		newBook.setYear(Integer.parseInt(year));
		
		System.out.println("check!!!!");
		bookService.createNewBook(newBook);
		
		return "redirect: /gscp/trading/home";
	}

	@RequestMapping(value = "/trading/repository/status", method = RequestMethod.POST)
	public String changeStatus(Locale locale, Model model,
			@ModelAttribute("current_user") User user,
			@RequestParam("book-id") int bookId)
	{
		Book cBook = bookService.getBookById(bookId);
		String cStatus = cBook.getStatus();
		
		if(cStatus.equals("Post")){
			cBook.setStatus("Host");
		}
		else{
			cBook.setStatus("Post");
		}
		
		bookService.updateBook(cBook);
		
		return "redirect: /gscp/trading/repository";
	}
	
	@RequestMapping(value = "/trading/repository/{bookNo}", method = RequestMethod.GET)
	public String updateBookDetail(Locale locale, Model model,
			@ModelAttribute("current_user") User user,
			@PathVariable int bookNo){
		
		Book cBook = bookService.getBookById(bookNo);

		model.addAttribute("book", cBook);
		model.addAttribute("type", "details");
		
		return "trading-repository";
	}
	
	@RequestMapping(value = "/trading/repository", method = RequestMethod.POST)
	public String updateBookDetail(Locale locale, Model model,
			@ModelAttribute("current_user") User user,
			@RequestParam("title") String title,
			@RequestParam("edition") String edition,
			@RequestParam("author") String author,
			@RequestParam("year") String year,
			@RequestParam("subject") String subject,
			@RequestParam("price") String price,
			@RequestParam("book-id") int bookId){
		Book cBook = bookService.getBookById(bookId);
		
		cBook.setTitle(title);
		cBook.setEdition(Integer.parseInt(edition));
		cBook.setAuthor(author);
		cBook.setYear(Integer.parseInt(year));
		cBook.setSubject(subject);
		cBook.setPrice(Integer.parseInt(price));
		
		bookService.updateBook(cBook);
		
		return "redirect: /gscp/trading/repository";
		
	}
	
	@RequestMapping(value = "/trading/market", method = RequestMethod.GET)
	public String BookMarket(Locale locale, Model model,
			@ModelAttribute("current_user") User user){
		ArrayList<Book> books = bookService.getBookByStatus("POST");
		
		model.addAttribute("current_user", user);
		model.addAttribute("books", books);
		model.addAttribute("model", "no_filter");
		
		return "trading-market";
	}
	
	@RequestMapping(value = "/trading/filtering/year", method = RequestMethod.POST)
	public String filterBooksByYear(Locale locale, Model model,
			@ModelAttribute("current_user") User use,
			@RequestParam("year_selection") String year_selection){
		
		ArrayList<Book> books = bookService.getBookByStatus("POST");
		ArrayList<Book> filtered_books = new ArrayList<Book>();
		int selection = Integer.parseInt(year_selection);
		
		for (int counter = 0; counter < books.size(); counter++) { 	
			Book cBook = bookService.getBookById(counter);
			if(selection == 1 && cBook.getYear() < 2000 ){
				filtered_books.add(cBook);
         	}
			else if(selection == 2 && cBook.getYear() >= 2000 ){
				filtered_books.add(cBook);
			}
	    }
		System.out.println("check!!!!");
		System.out.println(year_selection);
		
		model.addAttribute("filtered_books", filtered_books);
		model.addAttribute("model", "year");
		
		return "trading-market";
		
	}
	
	@RequestMapping(value = "/trading/new_order", method = RequestMethod.POST)
	public String createNewOrder(Locale locale, Model model, 
			@ModelAttribute("current_user") User user, 
			@RequestParam("item") int itemId){
		
		Book cBook = bookService.getBookById(itemId);
		
		Orders newOrder = new Orders();	
		newOrder.setBuyer(user.getId());
		newOrder.setItem(itemId);
		newOrder.setDate(new Date());
		newOrder.setSeller(cBook.getOwner());
		newOrder.setStatus("Completed");
		
		cBook.setOwner(user.getId());
		cBook.setStatus("Host");
		bookService.updateBook(cBook);
		
		orderService.createNewOrder(newOrder);
		
		return "redirect: /gscp/trading/orders";
	}
	
	@RequestMapping(value = "/trading/orders", method = RequestMethod.GET)
	public String listMyOrders(Locale locale, Model model,
			@ModelAttribute("current_user") User user){
		ArrayList<Orders> orders = orderService.getOrderByBuerId(user.getId());
		ArrayList<Book> books = bookService.getAllBooks();
		ArrayList<User> users = userService.getAllUsers();
		
		model.addAttribute("current_user", user);
		model.addAttribute("orders", orders);
		model.addAttribute("books", books);
		model.addAttribute("users", users);
		
		return "trading-orders";
	}
	
	@RequestMapping(value = "/trading/updated_history", method = RequestMethod.POST)
	public String deleteOrderHistory(Locale locale, Model model,
			@ModelAttribute("current_user") User user,
			@RequestParam("order-id") int orderId){
		Orders cOrder = orderService.getOrderById(orderId);
		
		orderService.deleteOrder(cOrder);
		System.out.println("check!!!!");
		
		return "redirect: /gscp/trading/orders";
		
	}
}