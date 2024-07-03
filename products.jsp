<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">

        <title>Kithara | Products</title>
        <link rel="shortcut icon" href="img/K.png"/>


        <!-- Additional CSS Files -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/font-awesome.css">

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/templatemo-hexashop.css">

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/owl-carousel.css">

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/lightbox.css">

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/table.css">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

    </head>
    <body>

        <!-- ***** Preloader Start ***** -->
        <div id="preloader">
            <div class="jumper">
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>  
        <!-- ***** Preloader End ***** -->
        <%@include file="navbar.jsp"%>

        <section class="intro">
            <div class="bg-image h-100" style="background-image: url('${pageContext.request.contextPath}/img/productsPage-bg.jpg'); background-size: cover;">
                <div class="mask d-flex align-items-center h-100" style="background-color: rgba(0,0,0,.5);">

                    <div class="container">
                        <div class="searchBox">
                            <form class="productForm">
                                <div class="row"> 
                                    <div class="col-sm-12">
                                        <input type="text" class="form-control" id="ID" name="ID" placeholder="Product Name">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="Name" name="Name" placeholder="Product ID" required>
                                    </div>
                                </div>

                                <button type="submit" class="btn btn-dark">Search</button>
                            </form>
                        </div>

                        <div class="alert alert-success alert-dismissible fade show " id="createSuccess" style="display: none;" role="alert">
                            <strong>Success!</strong> Product has been added
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>

                        <div class="alert alert-danger alert-dismissible fade show " id="createError" style="display: none;" role="alert">
                            <strong>Error!</strong> <c:out value='${customerDetails.userId}'/> Product ID already exist
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>

                        <div class="alert alert-success alert-dismissible fade show " id="updateSuccess" style="display: none;" role="alert">
                            <strong>Success!</strong> <c:out value='${customerDetails.userId}'/>Product has been updated
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>

                        <div class="alert alert-danger alert-dismissible fade show " id="updateError" style="display: none;" role="alert">
                            <strong>Error!</strong> <c:out value='${customerDetails.userId}'/> Something went wrong
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>

                        <div class="alert alert-warning alert-dismissible fade show " id="productDelete" style="display: none;" role="alert">
                            <strong>Success!</strong> <c:out value='${customerDetails.userId}'/> Product has been deleted
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>

                        <div class="row justify-content-center mt-3">
                            <div class="col-12">
                                <div class="card bg-dark shadow-2-strong" style="box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);">
                                    <div class="card-body">
                                        <div class="table-responsive"> 

                                            <table class="table table-dark table-borderless mb-0">
                                                <thead>
                                                    <tr>
                                                        <th scope="col">Product ID</th>
                                                        <th scope="col">Product Name</th>
                                                        <th scope="col">Description</th>
                                                        <th scope="col">Size</th>
                                                        <th scope="col">Price</th>
                                                        <th scope="col">Quantity</th>
                                                        <th scope="col">Action</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${productsList}" var="products">
                                                        <tr>

                                                            <td scope="row"><c:out value="${products.productsId}"/></td>
                                                            <td><c:out value="${products.productsName}"/></td>
                                                            <td><c:out value="${products.description}"/></td>
                                                            <td><c:out value="${products.size}"/></td>
                                                            <td><c:out value="${products.price}"/></td>
                                                            <td><c:out value="${products.quantity}"/></td>
                                                            <td>
                                                                <a href="${pageContext.request.contextPath}/products/update/form?productsId=${products.productsId}" class="btn btn-sm btn-link" style="color: white;"><i class="bi bi-pencil-square"></i></a>
                                                                <a href="${pageContext.request.contextPath}/products/delete?productsId=${products.productsId}" class="btn btn-sm btn-link" style="color: #F95757;"><i class="bi bi-trash3-fill"></i></a>
                                                            </td>

                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <form id="products" method="POST" action="${pageContext.request.contextPath}/products/create/form">
                            <button type="submit" class="btn btn-light mt-4" style="box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);">Add Product</button>
                        </form>
                    </div>
                </div>
            </div>
        </section>                             
        <%@include file="subscribe.jsp"%>
        <div class="page-heading about-page-heading" id="top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="inner-content">
                            <h2>Kithara</h2>
                            <span>Unleash Your Inner Shred: Find Your Perfect Tune at Kithara!</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <%@include file="footer.jsp"%>

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
            // Function to show or hide the alert based on the condition
            // Function to show or hide the alert based on the URL parameter
            function createSuccess() {
                var alertElement = document.getElementById("createSuccess"); // Select the element with the "alert" class

                // Check if the URL contains the "alert" parameter with the value "success"
                var urlParams = new URLSearchParams(window.location.search);
                if (urlParams.get("alert") === "successproduct") {
                    alertElement.style.display = "block"; // Show the alert if the parameter is present with the value "success"

                    // Reset the URL using history.replaceState
                    var newUrl = window.location.protocol + "//" + window.location.host + window.location.pathname;
                    window.history.replaceState({}, document.title, newUrl);
                } else {
                    alertElement.style.display = "none"; // Hide the alert in other cases, including page refresh
                }
            }

// Example usage:
            document.addEventListener("DOMContentLoaded", function () {
                createSuccess();
            });


        </script>

        <script>
            // Function to show or hide the alert based on the condition
            // Function to show or hide the alert based on the URL parameter
            function createError() {
                var alertElement = document.getElementById("createError"); // Select the element with the "alert" class

                // Check if the URL contains the "alert" parameter with the value "success"
                var urlParams = new URLSearchParams(window.location.search);
                if (urlParams.get("alert") === "errorProduct") {
                    alertElement.style.display = "block"; // Show the alert if the parameter is present with the value "success"

                    // Reset the URL using history.replaceState
                    var newUrl = window.location.protocol + "//" + window.location.host + window.location.pathname;
                    window.history.replaceState({}, document.title, newUrl);
                } else {
                    alertElement.style.display = "none"; // Hide the alert in other cases, including page refresh
                }
            }

// Example usage:
            document.addEventListener("DOMContentLoaded", function () {
                createError();
            });


        </script>


        <script>
            // Function to show or hide the alert based on the condition
            // Function to show or hide the alert based on the URL parameter
            function updateshowAlertOrHide() {
                var alertElement = document.getElementById("updateSuccess"); // Select the element with the "alert" class

                // Check if the URL contains the "alert" parameter with the value "success"
                var urlParams = new URLSearchParams(window.location.search);
                if (urlParams.get("alert") === "successupdate") {
                    alertElement.style.display = "block"; // Show the alert if the parameter is present with the value "success"

                    // Reset the URL using history.replaceState
                    var newUrl = window.location.protocol + "//" + window.location.host + window.location.pathname;
                    window.history.replaceState({}, document.title, newUrl);
                } else {
                    alertElement.style.display = "none"; // Hide the alert in other cases, including page refresh
                }
            }

// Example usage:
            document.addEventListener("DOMContentLoaded", function () {
                updateshowAlertOrHide();
            });


        </script>

        <script>
            // Function to show or hide the alert based on the condition
            // Function to show or hide the alert based on the URL parameter
            function updatecreateError() {
                var alertElement = document.getElementById("updateError"); // Select the element with the "alert" class

                // Check if the URL contains the "alert" parameter with the value "success"
                var urlParams = new URLSearchParams(window.location.search);
                if (urlParams.get("alert") === "errorupdate") {
                    alertElement.style.display = "block"; // Show the alert if the parameter is present with the value "success"

                    // Reset the URL using history.replaceState
                    var newUrl = window.location.protocol + "//" + window.location.host + window.location.pathname;
                    window.history.replaceState({}, document.title, newUrl);
                } else {
                    alertElement.style.display = "none"; // Hide the alert in other cases, including page refresh
                }
            }

// Example usage:
            document.addEventListener("DOMContentLoaded", function () {
                updatecreateError();
            });


        </script>
        
        <script>
            // Function to show or hide the alert based on the condition
            // Function to show or hide the alert based on the URL parameter
            function deleted() {
                var alertElement = document.getElementById("productDelete"); // Select the element with the "alert" class

                // Check if the URL contains the "alert" parameter with the value "success"
                var urlParams = new URLSearchParams(window.location.search);
                if (urlParams.get("alert") === "deleted") {
                    alertElement.style.display = "block"; // Show the alert if the parameter is present with the value "success"

                    // Reset the URL using history.replaceState
                    var newUrl = window.location.protocol + "//" + window.location.host + window.location.pathname;
                    window.history.replaceState({}, document.title, newUrl);
                } else {
                    alertElement.style.display = "none"; // Hide the alert in other cases, including page refresh
                }
            }

// Example usage:
            document.addEventListener("DOMContentLoaded", function () {
                deleted();
            });


        </script>
        
        
    </body>
</html>
