


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/customer.css">
        <meta charset="UTF-8">
        <title>Kithara | Customer Registration</title>
        <link rel="shortcut icon" href="img/K.png"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script><!-- comment -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.4.min.js"></script>

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/font-awesome.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/templatemo-hexashop.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/owl-carousel.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/lightbox.css">

        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <link rel="stylesheet" href="alert/dist/sweetalert.css">

    </head>
    <body>

        <input type="hidden" id="Status" value="<%= session.getAttribute("Status")%>">

        <div id="preloader">
            <div class="jumper">
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>  

        <div class="reg-bg">

            <div class="container h-100">
                <div class="d-flex justify-content-center h-100">

                    <div class="user_card regHeight">
                        <h4 style=" color: red;"><c:out value="${customer.regError}"/></h4>
                        <h1 class="pb-3 pt-2">Customer Registration</h1>



                        <form class="row g-3" id="signUp" method="POST" action="${pageContext.request.contextPath}/customer/create">
                            <div class="col-md-4">
                                <label for="validationDefault01" class="form-label">First name</label>
                                <input type="text" class="form-control" id="firstName" name="firstName"value="" placeholder="e.g. Juan" required>

                            </div>
                            <div class="col-md-4">
                                <label for="validationDefault01" class="form-label">Middle name</label>
                                <input type="text" class="form-control" id="middleName" value="" name="middleName"placeholder="Leave blank if none" >

                            </div>
                            <div class="col-md-4">
                                <label for="validationDefault02" class="form-label">Last name</label>
                                <input type="text" class="form-control" id="lastName" value="" name ="lastName" placeholder="e.g. Luna" required>

                            </div>
                            <div class="col-md-6">
                                <label for="validationDefault02" class="form-label">Birth date</label>
                                <input type="date" class="form-control" id="birthDate" value="" name="birthDate" required>

                            </div>
                            <div class="col-md-6">
                                <label for="validationDefault02" class="form-label">Mobile Number</label>
                                <input type="tel" class="form-control" id="Mobile" value="" name="Mobile" maxlength="11"
                                       placeholder="e.g. 09123456789" required>

                            </div>
                            <div class="col-md-8">
                                <label for="validationDefault03" class="form-label">Address</label>
                                <input type="text" class="form-control" id="Address" name="Address" placeholder="e.g. 7401 Georgia 26 Montezuma Georgia United States" required>

                            </div>
                            <div class="col-md-4 ">
                                <label for="validationDefault03" class="form-label">User Role</label>
                                <select class="form-select " aria-label="Default select example" id="userRole" name="userRole">
                                    <option selected>-select-</option>
                                    <option value="Administrator">Administrator</option>
                                    <option value="Customer">Customer</option>
                                </select>
                            </div>
                            <div class="col-md-4">
                                <label for="validationDefaultUsername" class="form-label">User ID</label>
                                <div class="input-group"> 
                                    <span class="input-group-text" id="inputGroupPrepend2">@</span>
                                    <input type="text" class="form-control" id="userName" name="userName" aria-describedby="inputGroupPrepend2" required>

                                </div>
                            </div>
                            <div class="col-md-4">
                                <label for="validationDefault01" class="form-label">Password</label>
                                <input type="password" class="form-control" id="Password" value="" name="Password" required>

                            </div>
                            <div class="col-md-4">
                                <label for="validationDefault01" class="form-label">Confirm Password</label>
                                <input type="password" class="form-control" id="confirmPassword" value="" name="Password" required>

                            </div>


                            <div class="d-flex justify-content-center">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="invalidCheck2" required>
                                    <label class="form-check-label links" for="invalidCheck2">
                                        By continuing, you agree to Kithara's<br><a href="#">Terms of Use</a> and <a href="#">Privacy Policy</a>
                                    </label>
                                </div>
                            </div>
                            <div class="d-flex justify-content-center mt-3 signup_container">
                                <button class="btn btn-light" type="submit" id="button" name="addRegister">Save</button>

                            </div>
                        </form>    
                        <div class="mt-4">
                            <div class="d-flex justify-content-center links">Already have an account? &nbsp;<a href="${pageContext.request.contextPath}/login" class="ml-2">Log In</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>





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
        <script src="${pageContext.request.contextPath}/assets/js/custom.js"></script>

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
            $(document).ready(function () {
                $('form').submit(function (e) {
                    e.preventDefault();

                    var userName = $('#userName').val();
                    var firstName = $('#firstName').val();
                    var middleName = $('#middleName').val();
                    var lastName = $('#lastName').val();
                    var Address = $('#Address').val();
                    var Mobile = $('#Mobile').val();
                    var Password = $('#Password').val();
                    var confirmPassword = $('#confirmPassword').val();


                    var firstNameRegex2 = /^.{1,}$/;
                    if (!firstNameRegex2.test(firstName)) {
                        alert("Invalid. First name must have at least 1 letter");
                        return;
                    }
                    var firstNameRegex = /^[a-zA-Z ]+$/;
                    if (!firstNameRegex.test(firstName)) {
                        alert("Invalid. First name must contain letters only");
                        return;
                    }






                    var middleNameRegex = /^[a-zA-Z\s]{0,}$/;
                    if (!middleNameRegex.test(middleName)) {
                        alert("Invalid. Middle name must contain letters only");
                        return;
                    }





                    var lastNameRegex = /^[a-zA-Z ]+$/;
                    if (!lastNameRegex.test(lastName)) {
                        alert('Invalid. Last name must contain letters only');
                        return;
                    }

                    var lastNameRegex1 = /^.{1,}$/;
                    if (!lastNameRegex1.test(lastName)) {
                        alert('Invalid. Last name must have at least 1 letter');
                        return;
                    }



                    var mobileRegex1 = /^[0-9]+$/;
                    if (!mobileRegex1.test(Mobile)) {
                        alert('Invalid. Mobile number must only contain numbers');
                        return;

                    }
                    var mobileRegex = /^\d{11}$/;
                    if (!mobileRegex.test(Mobile)) {
                        alert('Invalid. Mobile number must have 11 digits');
                        return;

                    }



                    var addressRegex = /^[A-Za-z0-9 ]+$/;
                    if (!addressRegex.test(Address)) {
                        alert('Invalid address. Please enter alphanumeric characters only.');
                        return;


                    }







                    var usernameRegex = /^.{4,5}$/;
                    if (!usernameRegex.test(userName)) {
                        alert("Username must be 4 to 5 characters only");
                        return;
                    }
                    var usernameRegex2 = /^[A-Za-z0-9]+$/;
                    if (!usernameRegex2.test(userName)) {
                        alert("Username must have alphanumeric characters only");
                        return;
                    }





                    var passwordRegex2 = /^.{8,}$/;
                    if (!passwordRegex2.test(Password)) {
                        alert("Invalid. Password must have at least 8 characters");
                        return;
                    }
                    var passwordRegex3 = /^.{1,16}$/;
                    if (!passwordRegex3.test(Password)) {
                        alert("Invalid. Password must only have a maximum of 16 characters");
                        return;
                    }
                    var passwordRegex4 = /.*[A-Z].*/;
                    if (!passwordRegex4.test(Password)) {
                        alert("Invalid. Password must have at least 1 capital letter");
                        return;
                    }
                    var passwordRegex5 = /.*[a-z].*/;
                    if (!passwordRegex5.test(Password)) {
                        alert("Invalid. Password must have at least 1 small letter");
                        return;
                    }
                    var passwordRegex6 = /.*\d.*/;
                    if (!passwordRegex6.test(Password)) {
                        alert("Invalid. Password must have at least 1 number");
                        return;
                    }
                    var passwordRegex7 = /.*[!@#$%^&*()\-_=+[\]{};':"\\|,.<>/?].*/;
                    if (!passwordRegex7.test(Password)) {
                        alert("Invalid. Password must have at least 1 special character");
                        return;
                    }

                    if (confirmPassword !== Password) {
                        alert("Password confirmation didn't match. Try again");
                        return;
                    }

                    $("#signUp")[0].submit();
                });
            });
        </script>



    </body>











</html>
