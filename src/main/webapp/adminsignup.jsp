<%--
  Created by IntelliJ IDEA.
  User: dec
  Date: 8/7/22
  Time: 9:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Sign Up Form by Colorlib</title>
        <!-- Font Icon -->
        <link rel="stylesheet"
              href="fonts/material-icon/css/material-design-iconic-font.min.css">
        <!-- Main css -->
        <link rel="stylesheet" href="css/style.css">
    </head>
</body>
<input type="hidden" id="status" value="<%= request.getAttribute("status")%>">
<div class="main">
    <!-- Sign up form -->
    <section class="signup">
        <div class="container">
            <div class="signup-content">
                <div class="signup-form">
                    <h2 class="form-title">Sign up</h2>
                    <form method="post" action="admin_signup" class="register-form"
                          id="register-form">
                        <div class="form-group">
                            <label for="name"><i
                                    class="zmdi zmdi-account material-icons-name"></i></label> <input
                                type="text" name="name" id="name" placeholder="Your Name" />
                        </div>
                        <div class="form-group">
                            <label for="password"><i class="zmdi zmdi-lock"></i></label> <input
                                type="password" name="password" id="password" placeholder="Password" />
                        </div>
                        <div class="form-group">
                            <label for="staffId"><i class="zmdi zmdi-lock"></i></label> <input
                                type="staffId" name="password" id="staffId" placeholder="staffId" />
                        </div>
                        <div class="form-group">
                            <label for="email"><i class="zmdi zmdi-email"></i></label> <input
                                type="email" name="email" id="email" placeholder="Your Email" />
                        </div>
                        <div class="form-group form-button">
                            <input type="submit" name="signup" id="signup"
                                   class="form-submit" value="SignUp" />
                        </div>
                    </form>
                </div>
                <div class="signup-image">
                    <figure>
                        <img src="images/adminsignup.jpg" alt="sign up image">
                    </figure>
                    <a href="adminlogin.jsp" class="signup-image-link">I am already
                        Staff</a>
                </div>
            </div>
        </div>
    </section>
</div>
<!-- JS -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="js/main.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="alert/dist/sweetalert.css">
<script type="text/javascript">
    let status = document.getElementById("status").value;
    if (status === "success"){
        swal("congrats","Account Created Successfully","success")
    }
</script>
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>

