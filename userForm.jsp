<!DOCTYPE html>
<head>
    <!-- templatemo 418 form pack -->
    <!-- 
    Form Pack
    http://www.templatemo.com/preview/templatemo_418_form_pack 
    -->
    <title>Kithara | User</title>
        <link rel="shortcut icon" href="img/K.png"/>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/user.css" rel="stylesheet" type="text/css">

    

</head>
<body class="templatemo-bg-image-2">
    
    <div class="container">
        <div class="col-md-12">			
            <form class="form-horizontal templatemo-contact-form-1" id="productForm" method="POST" action="${pageContext.request.contextPath}/user/added">
                <div class="form-group">
                    <div class="col-md-12">
                        <h1 class="margin-bottom-15 pt-4">User Form</h1>

                    </div>
                </div>				
                <div class="form-group">
                    <div class="col-md-12">		          	
                        <label for="name" class="control-label">User ID *</label>
                        <div class="templatemo-input-icon-container">

                            <input type="text" class="form-control" id="uID" name="uID" placeholder="" required>
                        </div>		            		            		            
                    </div>              
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <label for="email" class="control-label">First Name *</label>
                        <div class="templatemo-input-icon-container">

                            <input type="text" class="form-control" id="firstName" name="firstName" placeholder="" required>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <label for="website" class="control-label">Middle Name (optional)</label>
                        <div class="templatemo-input-icon-container">

                            <input type="text" class="form-control" id="middleName" name="middleName" placeholder="">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <label for="subject" class="control-label">Last Name *</label>
                        <div class="templatemo-input-icon-container">

                            <input type="text" class="form-control" id="lastName" name="lastName" placeholder="" required>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <label for="subject" class="control-label">User Role *</label>
                        <div class="templatemo-input-icon-container">

                            <select class="form-select" id="userRole" name="userRole" required>
                                <option selected>-- select user role --</option>
                                <option value="Admin">Admin</option>

                            </select>
                        </div>
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-md-12">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox"> Send a copy to my email.
                            </label>
                        </div>		            
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <form>
                            <input type="submit" value="Save" class="btn btn-light pull-right" style='color: black;'>
                        </form>
                    </div>
                </div>		    	
            </form>		      
        </div>
    </div>

    <script>
        $(document).ready(function () {
            $('form').submit(function (e) {
                e.preventDefault();
                var uID = $('#uID').val();
                var firstName = $('#firstName').val();
                var middleName = $('#middleName').val();
                var lastName = $('#lastName').val();



                var uIDRegex = /^[A-Za-z0-9]+$/;
                if (!uIDRegex.test(uID)) {
                    alert('Invalid user ID. Please enter alphanumeric characters only.');
                    return;
                }
                var uIDRegex1 = /^.{5,5}$/;
                if (!uIDRegex1.test(uID)) {
                    alert('Invalid. User ID must have 5 characters');
                    return;
                }

                var firstNameRegex2 = /^.{1,}$/;
                if (!firstNameRegex2.test(firstName)) {
                    alert("Invalid. First name must have at least 1 letter");
                    return;
                }
                var firstNameRegex = /^[a-zA-Z]+$/;
                if (!firstNameRegex.test(firstName)) {
                    alert("Invalid. First name must contain letters only");
                    return;
                }


                var middleNameRegex = /^[a-zA-Z\s]{0,}$/;
                if (!middleNameRegex.test(middleName)) {
                    alert("Invalid. Middle name must contain letters only");
                    return;
                }

                var lastNameRegex = /^[a-zA-Z]+$/;
                if (!lastNameRegex.test(lastName)) {
                    alert('Invalid. Last name must contain letters only');
                    return;
                }

                var lastNameRegex1 = /^.{1,}$/;
                if (!lastNameRegex1.test(lastName)) {
                    alert('Invalid. Last name must have at least 1 letter');
                    return;
                }


                $("#userForm")[0].submit();
            });
        });

    </script>
</body>
</html>
