package thoth.spring.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;
import thoth.spring.project.service.*;

import thoth.spring.project.vo.Order;

@Controller
public class OrderController {

    @Autowired
    private OrderService osrv;
    @Autowired
    private ProductService psrv;

    // write - 상품 등록 페이지
    @GetMapping("/product/porder")
    public ModelAndView porder(ModelAndView mv, String tnum) {
        mv.setViewName("product/porder.tiles");
        mv.addObject("p",psrv.readOneProduct(tnum));
        return mv;
    }

    // write - 상품 등록 완료
    @PostMapping("/product/porder")
    public String porderok(Order o){

        String returnPage = "redirect:/product/plist";

        if(osrv.newOrder(o))
            System.out.println("주문내역 등록이 완료되었습니다.");

        return returnPage;
    }

    // 나중에 지워야하는 코드 ------------------------------------------------

    @Autowired
    private BaProductService pbasrv;

    @Autowired
    private ChProductService pchsrv;

    @Autowired
    private CoProductService pcosrv;



    // write - 상품 등록 페이지
    @GetMapping("/product/porder2")
    public ModelAndView porder2(ModelAndView mv, String tnum) {
        mv.setViewName("product/porder2.tiles");
        mv.addObject("p",psrv.readOne2Product(tnum));
        return mv;
    }

    // write - 상품 등록 완료
    @PostMapping("/product/porder2")
    public String porder2ok(Order o){

        String returnPage = "redirect:/product/pchild";

        if(osrv.newOrder(o))
            System.out.println("주문내역 등록이 완료되었습니다.");

        return returnPage;
    }

    // write - 상품 등록 페이지
    @GetMapping("/product/baporder")
    public ModelAndView baporder(ModelAndView mv, String tnum) {
        mv.setViewName("product/baporder.tiles");
        mv.addObject("p",pbasrv.bareadOneProduct(tnum));
        return mv;
    }

    // write - 상품 등록 완료
    @PostMapping("/product/baporder")
    public String baporderok(Order o){

        String returnPage = "redirect:/product/bapchild";

        if(osrv.newOrder(o))
            System.out.println("주문내역 등록이 완료되었습니다.");

        return returnPage;
    }

    // write - 상품 등록 페이지
    @GetMapping("/product/chporder")
    public ModelAndView chporder(ModelAndView mv, String tnum) {
        mv.setViewName("product/chporder.tiles");
        mv.addObject("p",pchsrv.chreadOneProduct(tnum));
        return mv;
    }

    // write - 상품 등록 완료
    @PostMapping("/product/chporder")
    public String chporderok(Order o){

        String returnPage = "redirect:/product/chpchild";

        if(osrv.newOrder(o))
            System.out.println("주문내역 등록이 완료되었습니다.");

        return returnPage;
    }


    // write - 상품 등록 페이지
    @GetMapping("/product/coporder")
    public ModelAndView coporder(ModelAndView mv, String tnum) {
        mv.setViewName("product/coporder.tiles");
        mv.addObject("p",pcosrv.coreadOneProduct(tnum));
        return mv;
    }

    // write - 상품 등록 완료
    @PostMapping("/product/coporder")
    public String coporderok(Order o){

        String returnPage = "redirect:/product/copchild";

        if(osrv.newOrder(o))
            System.out.println("주문내역 등록이 완료되었습니다.");

        return returnPage;
    }

}
