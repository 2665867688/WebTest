package com.yue.webtest.servlet;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HelloWorld extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public HelloWorld() {
        super();
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //在这里也可以请求数据库 将数据库数据响应给客户端
        // 你的第一个接口请求返回json字符串
        if (request.getParameter("name") != null) {
            //request.getParameter("name")方法获取客户端请求数据
            System.out.println("My name is doGet()");
            // 处理中文 获取浏览器的请求数据 String
            String name = new String(request.getParameter("name")
                    .getBytes("ISO8859-1"), "UTF-8");
            // 指定服务器相应的编码格式为utf-8:支持中文
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();

            for (int i = 0; i < 10; i++) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("oneKey", "one");
                map.put("twoKey", "tow");
                map.put("thirdKey", "third");
                map.put("chineseTest", "小明");
                map.put("name", name);
                list.add(map);
            }
            String json = gson.toJson(list);
            //输出json字符串给客户端 响应
            out.print(json);
            out.flush();
            out.close();
        } else {

        }
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("My name is doPost");
        // 方法请求的方法,一般情况下web程序员都是用这种处理方式get安全性非常低，post安全性较高。但是执行效率却比Post方法好
        doGet(request, response);
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
        // Put your code here
    }

}
