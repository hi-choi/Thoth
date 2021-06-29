package thoth.spring.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import thoth.spring.project.service.KProductService;
import thoth.spring.project.service.LProductService;
import thoth.spring.project.utils.ImgUploadUtil;
import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Product;

@Controller
public class LProductController {

    @Autowired
    private LProductService plsrv;
    @Autowired
    private ImgUploadUtil imgUtil;

    @GetMapping("/product/lplist")
    public ModelAndView lplsit(ModelAndView mv, String cp) {
        if(cp==null) cp="1";
        mv.setViewName("product/lplist.tiles");
        mv.addObject("pds",plsrv.lreadProduct(cp));   // 상품 조회
        mv.addObject("pcnt",plsrv.lcountProduct());   // 상품 전체 수 구하기
        return mv;
    }

    @GetMapping("/product/lfind")
    public ModelAndView lfind(ModelAndView mv, String cp, String findtype, String findkey){
        mv.setViewName("product/lplist.tiles");
        mv.addObject("pds",plsrv.lreadProduct(cp,findtype,findkey));  // 검색
        mv.addObject("pcnt",plsrv.lcountProduct(findtype,findkey));   // 검색된 상품 수 구하기

        return mv;
    }

    @GetMapping("/product/lpwrite")
    public String lpwrite() {return "product/lpwrite.tiles";}

    @PostMapping("/product/lpwrite")
    public String lpwriteok(Product p, BookImage b, MultipartFile[] img){

        String returnPage = "redirect:/product/lplist";

        if(plsrv.lnewProduct(p,b,img))
            System.out.println("상품 등록이 완료되었습니다.");

        return returnPage;
    }

    @GetMapping("/product/lpviewchild")
    public ModelAndView lpview(String tnum, ModelAndView mv) {

        mv.setViewName("product/lpview.tiles");
        mv.addObject("p", plsrv.lreadOneProduct(tnum));   // tnum 상품 정보 조회
        mv.addObject("b",plsrv.lreadOneImage(tnum)); // 이미지 조회
        return mv;
    }

    @GetMapping("/product/lpremove")
    public String lpremove(String tnum){
        Product p = plsrv.lremoveProduct(tnum); // 상품 삭제
        BookImage b = plsrv.lremoveImage(tnum); // 상품 이미지 삭제
        imgUtil.removeImage(b);

        return "redirect:/product/lplist";
    }

    @GetMapping("/product/lpupdate")
    public ModelAndView lpupdate(ModelAndView mv, String tnum)
    {
        mv.setViewName("product/lpupdate.tiles");
        mv.addObject("p",plsrv.lreadOneProduct(tnum));
        mv.addObject("b",plsrv.lreadOneImage(tnum));
        return mv;
    }

    @PostMapping("/product/lpupdate")
    public String lpupdateok(Product p,BookImage b, MultipartFile[] img){
        plsrv.lmodifyProduct(p);
        if(b.getTodie()!=""){
            plsrv.lmodifyImage(b,img);
        }
        return "redirect:/product/lplist";
    }

}
