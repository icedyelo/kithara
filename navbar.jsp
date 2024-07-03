
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kithara</title>
        <link rel="shortcut icon" href="img/K.png"/>
    </head>
    <body>
        <header class="header-area header-sticky">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <nav class="main-nav">
                            <!-- ***** Logo Start ***** -->
                            <a href="index.jsp" class="logo">
                                <img src="${pageContext.request.contextPath}/assets/images/logo.png">
                            </a>
                            <!-- ***** Logo End ***** -->
                            <!-- ***** Menu Start ***** -->
                            <ul class="nav">
                                <li class="scroll-to-section"><a href="${pageContext.request.contextPath}/home" class="active">Home</a></li>
                                <li class="scroll-to-section"><a href="${pageContext.request.contextPath}/about">About Us</a></li>
                                <li class="scroll-to-section"><a href="${pageContext.request.contextPath}/products">Products</a></li>
                                <li class="scroll-to-section"><a href="${pageContext.request.contextPath}/customer">User</a></li>
                                <li class="scroll-to-section"><a href="${pageContext.request.contextPath}/contact">Contact Us</a></li>
                            </ul>        
                            <a class='menu-trigger'>
                                <span>Menu</span>
                            </a>
                            <!-- ***** Menu End ***** -->
                        </nav>
                    </div>
                </div>
            </div>
        </header>
    </body>
</html>
