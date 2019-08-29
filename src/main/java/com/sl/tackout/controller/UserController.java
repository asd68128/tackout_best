package com.sl.tackout.controller;

import com.sl.tackout.pojo.UserTable;
import com.sl.tackout.service.UserService;
import com.sl.tackout.utils.ImgCode;
import com.sl.tackout.utils.MD5;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by happy on 2019/8/21.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("reg")
    public String reg() {
        return "reg";
    }

    @RequestMapping("login")
    public String login() {
        return "login";
    }
    @RequestMapping("loginOut")
    public String loginOut() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();//用户登出，清除用户在shiro中的驻留信息
        return "redirect:login";
    }
    @RequestMapping("main")//用户主页面
    public String main() {
        return "main";
    }

    @RequestMapping("user_center")//用户个人中心
    public String userCenter(){
        return "user_center";
    }

    @RequestMapping("bm_pay")//购买会员
    public String bmPay(){
        return "bm_pay";
    }
    @RequiresPermissions("coupon")
    @RequestMapping("member_coupon")//领取优惠券
    public String buyingMembers() {
        return "member_coupon";
    }
    @RequestMapping("drink")//点餐
    public String drink() {
        return "drink";
    }
    @RequestMapping("order")//提交订单
    public String pay() {
        return "order";
    }




    //验证码显示
    @RequestMapping("getImg")
    public void getImg(HttpServletRequest request, HttpServletResponse response) {
        new ImgCode().getRandcode(request, response);
    }

    //    注册
    @RequestMapping("register")
    public String register(String userName, String userPwd, String userPhone, String userImgCode, Model model, HttpSession session) {
        if (userName != null && userName != "" && userPwd != null && userPwd != "" && userPhone != null && userPhone != "") {
//            String imgCode = (String) session.getAttribute(ImgCode.RANDOMCODEKEY);
//            if (StringUtils.startsWithIgnoreCase(imgCode,userImgCode)) {//验证码正确
//            }
            UserTable userByLoginName = userService.findUserByLoginName(userName);
            if (userByLoginName != null) {
                model.addAttribute("error", "您输入的用户名已存在，请重新输入");
                return "reg";
            } else {
                int UserId = userService.findMaxUserId() + 1;
                String md5Upwd = new MD5().getMD5ofStr(userPwd);
                Date date = new Date();
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
                UserTable userTable = new UserTable(UserId, userName, md5Upwd,null,userPhone,null, date, null);
                boolean b = userService.addUser(userTable);
                if (b) {//添加成功
                    return "login";
                } else {
                    model.addAttribute("error", "注册失败,请再试一遍");
                    return "reg";
                }
            }
        } else {
            model.addAttribute("error", "必填项不能为空");
            return "reg";
        }
    }

    //    登录验证
    @RequestMapping("isLogin")
    public String isLogin(String userName, String userPwd, String userImgCode, Model model,HttpSession session) {
        if (userName != null && userName != "" && userPwd != null && userPwd != "" && userImgCode != null && userImgCode != "") {
//            String imgCode = (String) session.getAttribute(ImgCode.RANDOMCODEKEY);
//            if (StringUtils.startsWithIgnoreCase(imgCode,userImgCode)) {//验证码正确
//            }
            Subject subject = SecurityUtils.getSubject();
            String md5Upwd = new MD5().getMD5ofStr(userPwd);
            UsernamePasswordToken token = new UsernamePasswordToken(userName,md5Upwd);
            try {
                subject.login(token);
                if (subject.isAuthenticated()) {
                    session.setAttribute("userName",userName);
                    return "main";
                } else {
                    model.addAttribute("error", "登录失败,请再试一遍");
                    return "login";
                }
            } catch (UnknownAccountException un) {
                model.addAttribute("error", "用户名不存在");
                return "login";
            } catch (IncorrectCredentialsException ice) {
                model.addAttribute("error", "用户名或密码错误");
                return "login";
//            }catch (AuthorizationException az){//权限不足
//                model.addAttribute("error", "你没有权限");
            } catch (AuthenticationException ae) {//身份验证失败
                ae.printStackTrace();
            }
            return "login";
        }else {//输入空信息
            model.addAttribute("error", "请输入完整的用户名密码");
            return "login";
        }
    }

}
