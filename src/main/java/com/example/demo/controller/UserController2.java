//package com.example.demo.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import com.example.demo.entity.User;
//import com.example.demo.repository.UserRepository;
//
//import jakarta.servlet.http.HttpSession;
//import jakarta.transaction.Transactional;
//
//@Controller
//public class UserController2 {
//
//    @Autowired
//    private UserRepository userRepository;
//    
//    
//    
//    @GetMapping("/signup")
//    public String createUserForm(Model model) {
//        model.addAttribute("user", new User());
//        return "signup";
//    }
//    
//
//    
//    @PostMapping("/signup")
//    public String createUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
//    	try {
//            // 사용자가 존재하지 않을 때만 토큰 생성 및 저장, 이메일 전송
//            UUID uuid = UUID.randomUUID();
//            
//            
//            
//            
//            userRepository.save(user);
//           
//            
////            // 인증 링크 생성
////            String verificationLink = "http://localhost:8080/verifyEmail/" + verificationToken;
////
////            // 이메일 전송 메소드 호출
////            sendButtonEmail(user.getEmail(), "모두의 레시피 이메일 인증입니다!", "인증하기", verificationLink);
//            
//            // 성공 시 메시지 설정
//            redirectAttributes.addFlashAttribute("successMessage", "회원가입이 완료되었습니다. 이메일을 확인하세요!");
//            
//            return "redirect:/login";
//        } catch (Exception e) {
//            throw new RuntimeException("회원가입 중 오류 발생", e);
//        }
//    }
//    
//    
//    @GetMapping("/editUser/{user_id}")
//    public String editUserForm(@PathVariable String user_id, Model model) {
//        User user = userRepository.findById(user_id).orElseThrow(() -> new IllegalArgumentException("Invalid User ID: " + user_id));
//        model.addAttribute("user", user);
//        return "editUser";
//    }
//    
//    @PostMapping("/editUser/{user_id}")
//    public String editUser(@PathVariable String user_id, @ModelAttribute User user) {
//        userRepository.save(user);
//        return "redirect:/user";
//    }
//    
//    @GetMapping("/deleteUser/{nickname}")
//    @Transactional // 트랜잭션 설정
//    public String deleteUser(@PathVariable String nickname, HttpSession session) {
//        User user = userRepository.findbynickname(nickname);
//       
//        List<Integer> postIds = new ArrayList<>();
//        
//       
//        
//        userRepository.deleteById(user.getUser_id());
//        session.removeAttribute("loggedInNickname");
//        session.removeAttribute("loggedInUserId");
//        return "redirect:/user";
//    }
//    
//    @GetMapping("/deleteUserr/{nickname}")
//    @Transactional // 트랜잭션 설정
//    public String deleteUserr(@PathVariable String nickname, HttpSession session, RedirectAttributes redirectAttributes) {
//        User user = userRepository.findbynickname(nickname);
//        
//        List<Integer> postIds = new ArrayList<>();
//        
//  
//        userRepository.deleteById(user.getUser_id());
//        
//        session.removeAttribute("loggedInNickname");
//        session.removeAttribute("loggedInUserId");
//        redirectAttributes.addFlashAttribute("deleteMessage", "회원탈퇴가 완료 되었습니다!");
//        return "redirect:/";
//    }
//   
//    
//    @GetMapping("/checkUserIdAvailability")
//    @ResponseBody
//    public boolean checkUserIdAvailability(@RequestParam String user_id) {
//        // 데이터베이스에서 해당 사용자 이름을 검색하여 결과 확인
//       List<User> existingUser = userRepository.findByUser_id(user_id);
//        
//        // 중복 여부에 따라 결과 반환
//        return existingUser.isEmpty(); // true는 중복이 아님, false는 중복임
//    }
//    
//    @GetMapping("/checkUseremailAvailability")
//    @ResponseBody
//    public boolean checkUseremailAvailability(@RequestParam String email) {
//        // 데이터베이스에서 해당 사용자 이름을 검색하여 결과 확인
//       List<User> existingUser = userRepository.findByemailList(email);
//        
//        // 중복 여부에 따라 결과 반환
//        return existingUser.isEmpty(); // true는 중복이 아님, false는 중복임
//    }
//    
//    @GetMapping("/checkUsernicknameAvailability")
//    @ResponseBody
//    public boolean checkUsernicknameAvailability(@RequestParam String nickname) {
//        // 데이터베이스에서 해당 사용자 이름을 검색하여 결과 확인
//       List<User> existingUser = userRepository.findBynicknameList(nickname);
//        
//        // 중복 여부에 따라 결과 반환
//        return existingUser.isEmpty(); // true는 중복이 아님, false는 중복임
//    }
//    
//
//    
//	
//}
