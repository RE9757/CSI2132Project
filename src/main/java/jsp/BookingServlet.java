package jsp;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import sql.Booking;
import sql.BookingService;

@WebServlet(name = "BookingServlet", value="/BookingServlet")
public class BookingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Booking booking = new Booking(Integer.valueOf(Long.toString(System.currentTimeMillis())), (int) req.getSession().getAttribute("id"), Integer.parseInt(req.getParameter("total-rooms")), StringToDate(req.getParameter("sdate")), StringToDate(req.getParameter("edate")));
        BookingService bookingService = new BookingService();
        try {
            bookingService.createBooking(booking);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("booking.html");
    }

    private Date StringToDate(String date){
        SimpleDateFormat tmp = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = null;
        try{
            d = tmp.parse(date);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return new Date(d.getTime());
    }
}
