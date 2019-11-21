package com.tuanlq.midexam.controller;

import com.tuanlq.midexam.model.Book;
import com.tuanlq.midexam.model.Category;
import com.tuanlq.midexam.services.CategoryService;
import com.tuanlq.midexam.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public ModelAndView listCategory(){
        Iterable<Category> categories = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("categories",categories);
        return  modelAndView;
    }
    @GetMapping("create-category")
    public ModelAndView getFormCreateCategory(){
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("create-category")
    public ModelAndView saveCategory(@ModelAttribute Category category){
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        modelAndView.addObject("message","New category created successfully");
        return modelAndView;
    }

    @GetMapping("/delete-category/{id}")
    public ModelAndView loadFormDelete(@PathVariable Long id){
        Category category = categoryService.findById(id);
        if(category != null) {
            ModelAndView modelAndView = new ModelAndView("/category/delete");
            modelAndView.addObject("category", category);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-category")
        public String deleteCategory(@ModelAttribute("category") Category category){
            categoryService.remove(category.getId());
            return "redirect:categories";
    }
//
     @GetMapping("/edit-category/{id}")
    public ModelAndView getFormEditCategory(@PathVariable Long id){
        Category category = categoryService.findById(id);
        if(category !=null){
            ModelAndView modelAndView = new ModelAndView("/category/edit");
            modelAndView.addObject("category", category);
            return modelAndView;
        } else{
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/edit-category")
    public ModelAndView updateDepartment(@ModelAttribute Category category)
    {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("category",category);
        modelAndView.addObject("message", "Category update successfully");
        return modelAndView;
    }
    @GetMapping("/view-category/{id}")
    public ModelAndView viewCategory(@PathVariable Long id)
    {
        Category category = categoryService.findById(id);
        if(category == null){
            ModelAndView modelAndView = new ModelAndView("/error.404");
        }
        Iterable<Book> books = bookService.findAllByCategory(category);
        ModelAndView modelAndView = new ModelAndView("/category/view");
        modelAndView.addObject("category",category);
        modelAndView.addObject("books",books);
        return modelAndView;
    }







}
