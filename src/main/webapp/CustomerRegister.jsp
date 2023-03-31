<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title> Customer Register </title>
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="/assets/css/styles.css">
</head>

<body>

    <jsp:include page="navbar.jsp"/>

    <div class="container">
        <div class="row" id="row">
            <div class="col-md-12">
                <form class="form-horizontal" name="student-form" action="CustomerRegisterController.jsp" method="POST">
                    <div class="form-group col-sm-3 mb-3">
                        <label for="SINSSN">SIN/SSN</label>
                        <input type="number" class="form-control" name="SINSSN" placeholder="Enter your SIN or SSN">
                    </div>
                    <div class="form-group col-sm-3 mb-3">
                        <label for="Address">Address</label>
                        <input type="text" class="form-control" name="Address" placeholder="Enter your address">
                    </div>
                    <div class="form-group col-sm-3 mb-3">
                        <label for="FullName">Full Name</label>
                        <input type="text" class="form-control" name="FullName" placeholder="Enter you full name">
                    </div>
                    <button type="submit" class="btn btn-primary btn-submit-custom">Submit</button>
                </form>
            </div>
        </div>

        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>