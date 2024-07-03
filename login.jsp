<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/2login.css">
        <meta charset="UTF-8">
        <title>Kithara | Log In</title>
        <link rel="shortcut icon" href="img/K.png"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script><!-- comment -->

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/font-awesome.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/templatemo-hexashop.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/owl-carousel.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/lightbox.css">

    </head>

    <body>
        <div id="preloader">
            <div class="jumper">
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
        <div class="log-bg">
            
            <div class="container h-100">
                <div class="d-flex justify-content-center h-100">
                    <div class="user_card">
                        <div class="d-flex justify-content-center">
                            <div class="logo_container">
                                <img src="${pageContext.request.contextPath}/img/K.png" class="logo" alt="Logo">
                            </div>
                        </div>
                        <div class="d-flex justify-content-center form_container">
                            <form method="post" action="${pageContext.request.contextPath}/home">
                                <div class="input-group mb-3">
                                    <div class="input-group"> 
                                        <span class="input-group-text" id="inputGroupPrepend2">@</span>
                                        <input type="text" class="form-control" id="validationDefaultUsername uName" aria-describedby="inputGroupPrepend2" placeholder="User ID" name="uID">
                                    </div>

                                </div>
                                <div class="input-group mb-2">
                                    <div class="input-group"> 
                                        <span class="input-group-text" id="inputGroupPrepend2">*</span>
                                        <input type="password" class="form-control input_pass" placeholder="password" id="pass" name="pass">
                                    </div>

                                </div>

                                <div class="form-group">
                                    <div class="custom-control custom-checkbox">
                                        <input type="checkbox" class="custom-control-input" id="customControlInline" >
                                        <label class="custom-control-label" for="customControlInline">Remember me</label>
                                    </div>
                                </div>
                                <div class="d-flex justify-content-center mt-3 login_container">
                                    <button type="submit" class="btn btn-light">Login</button>
                                </div>
                            </form>
                        </div>

                        <div class="mt-4 line">
                            <div class="d-flex justify-content-center links">
                                Don't have an account? <a href="${pageContext.request.contextPath}/customer/create/form" class="ml-2"> &nbsp;Register</a>
                            </div>
                            <div class="d-flex justify-content-center links">
                                <a href="#">Forgot your password?</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- jQuery -->
        <script src="${pageContext.request.contextPath}/assets/js/jquery-2.1.0.min.js"></script>

        <!-- Bootstrap -->
        <script src="${pageContext.request.contextPath}/assets/js/popper.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>

        <!-- Plugins -->
        <script src="${pageContext.request.contextPath}/assets/js/owl-carousel.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/accordions.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/datepicker.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/scrollreveal.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/waypoints.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/jquery.counterup.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/imgfix.min.js"></script> 
        <script src="${pageContext.request.contextPath}/assets/js/slick.js"></script> 
        <script src="${pageContext.request.contextPath}/assets/js/lightbox.js"></script> 
        <script src="${pageContext.request.contextPath}/assets/js/isotope.js"></script> 

        <!-- Global Init -->
        <script src="${pageContext.request.contextPath}/assets/js/custom.js"></script>>

        <script>

            $(function () {
                var selectedClass = "";
                $("p").click(function () {
                    selectedClass = $(this).attr("data-rel");
                    $("#portfolio").fadeTo(50, 0.1);
                    $("#portfolio div").not("." + selectedClass).fadeOut();
                    setTimeout(function () {
                        $("." + selectedClass).fadeIn();
                        $("#portfolio").fadeTo(50, 1);
                    }, 500);

                });
            });

        </script>
        
        <script>
            $('.alert').alert();
        </script> 
        
    </body>
    
    
</html>