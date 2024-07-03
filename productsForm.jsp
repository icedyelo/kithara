<!DOCTYPE html>
<head>
    <!-- templatemo 418 form pack -->
    <!-- 
    Form Pack
    http://www.templatemo.com/preview/templatemo_418_form_pack 
    -->
    <title>Kithara | Products</title>
    <link rel="shortcut icon" href="img/K.png"/>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/templatemo_style.css" rel="stylesheet" type="text/css">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/font-awesome.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/templatemo-hexashop.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/owl-carousel.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/lightbox.css">

</head>
<body class="templatemo-bg-image-2">

    <div id="preloader">
        <div class="jumper">
            <div></div>
            <div></div>
            <div></div>
        </div>
    </div>
    <div class="container">
        <div class="col-md-12">			
            <form class="form-horizontal templatemo-contact-form-1" id="productForm" method="POST" action="${pageContext.request.contextPath}/products/create">
                <div class="form-group">
                    <div class="col-md-12">
                        <h1 class="margin-bottom-15 pt-4">Product Form</h1>

                    </div>
                </div>				
                <div class="form-group">
                    <div class="col-md-12">		          	
                        <label for="name" class="control-label">Product's ID *</label>
                        <div class="templatemo-input-icon-container">

                            <input type="text" class="form-control" id="productsId" name="productsId" placeholder="" required>
                        </div>		            		            		            
                    </div>              
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <label for="email" class="control-label">Product's Name *</label>
                        <div class="templatemo-input-icon-container">

                            <input type="text" class="form-control" id="productsName" name="productsName" placeholder="" required>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <label for="website" class="control-label">Description *</label>
                        <div class="templatemo-input-icon-container">

                            <input type="text" class="form-control" id="description" name="description" placeholder="" required>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <label for="subject" class="control-label">Size *</label>
                        <div class="templatemo-input-icon-container">

                            <input type="text" class="form-control" id="size" name="size" placeholder="" required>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <label for="subject" class="control-label">Price *</label>
                        <div class="templatemo-input-icon-container">

                            <input type="text" class="form-control" id="price" name="price" placeholder="" required>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <label for="subject" class="control-label">Quantity *</label>
                        <div class="templatemo-input-icon-container">

                            <input type="text" class="form-control" id="quantity" name="quantity" placeholder="" required>
                        </div>
                    </div>
                </div>

                
                <div class="form-group">
                    <div class="col-md-12">
                        <form>
                            <input type="submit" value="Save" class="btn btn-light pull-right" name="addProducts"  style='color: black;'>
                        </form>
                    </div>
                </div>		    	
            </form>		      
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
            $(document).ready(function () {
                $('form').submit(function (e) {
                    e.preventDefault();
                    var productsId = $('#productsId').val();
                    var productsName = $('#productsName').val();
                    var description = $('#description').val();
                    var size = $('#size').val();
                    var price = $('#price').val();
                    var quantity = $('#quantity').val();

                    var productsIdRegex = /^[1-9][0-9]*$/;
                    if (!productsIdRegex.test(productsId)) {
                        alert('Invalid ID. Please enter a number greater than zero.');
                        return;
                    }

                    var productsNameRegex = /^[a-zA-Z ]+$/;
                    if (!productsNameRegex.test(productsName)) {
                        alert('Invalid. Product name must contain letters only');
                        return;
                    }
                    var productsNameRegex1 = /^.{3,}$/;
                    if (!productsNameRegex1.test(productsName)) {
                        alert('Invalid. Product name must contain at least 3 characters');
                        return;
                    }

                    var descriptionRegex = /^[a-zA-Z ]+$/;
                    if (!descriptionRegex.test(description)) {
                        alert('Invalid. Description must contain letters only');
                        return;
                    }
                    var descriptionRegex1 = /^.{3,}$/;
                    if (!descriptionRegex1.test(description)) {
                        alert('Invalid. Description must contain at least 3 characters');
                        return;
                    }

                    var sizeRegex = /^[a-zA-Z0-9\s]+$/;
                    if (!sizeRegex.test(size)) {
                        alert('Invalid. Size must contain alphanumeric characters only.');
                        return;
                    }

                    var priceRegex = /^\s*(?=.*[1-9])\d*(?:\.\d{1,})?\s*$/;
                    if (!priceRegex.test(price)) {
                        alert('Invalid price. Please enter a number greater than zero.');
                        return;
                    }

                    var quantityRegex = /^[1-9][0-9]*$/;
                    if (!quantityRegex.test(quantity)) {
                        alert('Invalid quantity. Please enter a number greater than zero.');
                        return;
                    }

                    $("#productForm")[0].submit();
                });
            });

        </script>
</body>
</html>
