package com.example.book.controller;

import com.example.book.pojo.Books;
import com.example.book.service.BooksService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Api(tags = "图书相关接口", description = "提供图书相关的 Rest API")
@Controller
public class BookController {
    private static Logger logger = LoggerFactory.getLogger(BookController.class);
    @Autowired
    private BooksService booksService;

    @ApiOperation("查询全部图书接口")
    @GetMapping("/book/getBooks")
    public String getBooks(Model model){
        try{

            List<Books> list = this.booksService.getBooks();
            logger.info("getBooks list:"+list);
            model.addAttribute("list",list);
        }catch(Exception e){
            e.printStackTrace();
            logger.error("getBooks error:"+e.getMessage());
            return "error";
        }
        return "showBooks";
    }


    @ApiOperation(" 预更新图书查询接口")
    @GetMapping("/book/preUpdateBook/{bookId}")
    public String preUpdateBook(@PathVariable("bookId") int bookId,Model model){
        try{
            Books book = this.booksService.preUpdateBook(bookId);
            logger.info("preUpdateBook book:"+book);
            model.addAttribute("book",book);
        }catch(Exception e){
            e.printStackTrace();
            logger.error("preUpdateBook error:"+e.getMessage());
            return "error";
        }
        return "updateBook";
    }

    @ApiOperation("更新图书接口")
    @PostMapping("/book/updateBook")
    public String updateUser(Books book){
        try{
            this.booksService.updateBook(book);
        }catch(Exception e){
            e.printStackTrace();
            logger.error("updateBook error:"+e.getMessage());
            return "error";
        }
        return "ok";
    }

    @ApiOperation("跳转添加图书界面")
    @GetMapping("/book/preAddBook")
    public String preAddBook(){
        return "addBook";
    }


    @ApiOperation("添加图书接口")
    @PostMapping("/book/addBook")
    public String addBook(Books book){
        try{
            this.booksService.addBook(book);
        }catch(Exception e){
            e.printStackTrace();
            logger.error("addBook error:"+e.getMessage());
            return "error";
        }
        return "ok";
    }


    @ApiOperation("删除图书接口")
    @GetMapping("/book/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int bookId, Model model){
        try{
            this.booksService.deleteBook(bookId);
        }catch(Exception e){
            e.printStackTrace();
            logger.error("deleteBook error:"+e.getMessage());
            return "error";
        }
        return "ok";
    }
}
