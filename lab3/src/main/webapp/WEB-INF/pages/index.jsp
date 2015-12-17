<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Lab2</title>
    <!-- Bootstrap Core CSS - Uses Bootswatch Flatly Theme: http://bootswatch.com/flatly/ -->

    <!-- Bootstrap -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/bootstrap-theme.min.css" rel="stylesheet">
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header page-scroll">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="javascript:void(0)">Lab2</a>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>


<br><br>
<div class="container">
    <div class="row">
        <h2 class="sub-header">Photos</h2>

        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                <tr class="success">
                    <th>id</th>
                    <th>name</th>
                    <th>source</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${photos}" var="photo">
                    <tr>
                        <th>${photo.id}</th>
                        <th>${photo.name}</th>
                        <th>${photo.source}</th>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Add photo</button>
        <br><br>

    </div>
    <div class="blue-background-below">
        <div class="container text-center">
            <div class="row">
                <div class="col-lg-12">
                    Copyright &copy; Troshchuk 2015
                </div>
            </div>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Add photo</h4>
                </div>
                <div class="modal-body">
                    <form method="post" action="add_photo">
                        <input type="text" placeholder="id" name="id">
                        <input type="text" placeholder="name" name="name">
                        <input type="text" placeholder="source" name="source">
                        <input type="submit" class="btn btn-success">
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>
</div>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<!-- jQuery -->
<script src="resources/js/jquery.js"></script>

<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>