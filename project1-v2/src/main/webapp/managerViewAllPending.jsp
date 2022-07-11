<%@ page import = "java.util.List"%>
<%@ page import = "com.example.entity.Employee"%>
<%@ page import = "com.example.entity.ExpReimbursementReq"%>

<%
Employee empl = (Employee) request.getAttribute("emp");
%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" type="text/css" href="main.css">
    <title>Manager - View All Requests</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="managerHome.html">
            <img src="images/VLZlogo2.png">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="managerHome.html">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ViewReimbursement">Reimbursements</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="submitRequest">Submit a Request</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="employeeInfo">View Info</a>
                </li>

            </ul>
            <ul class="d-flex ml-auto navbar-nav me-auto mb-2 mb-lg-0" >
                <li class="nav-item">
                    <a class="nav-link" href="logout">Logout</a>
                </li>
            </ul>

        </div>
    </div>
</nav>


<div class="jumbotron">
    <h1 class="display-4">View All Employee Reimbursement Requests</h1>
</div>

<div class="container">
    <div class="row" id="projectSummary">
        <h1>Reimbursement Table</h1>
        <p class="lead">As a manager, you are able to view every employee's reimbursement requests and either approve or deny them.</p>
    </div>
</div>

<div class="d-flex align-items-center justify-content-center">
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <li class="nav-item">
                    <a class="nav-link"  href="ViewAllReimbursement">All Requests</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link"  href="ViewAllPending">All Pending</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ViewAllResolved">All Resolved</a>
                </li>
        </div>
    </div>
</nav>
</div>


<div class="container">
    <table class="table table-bordered justify-content-center">
        <span class="border border-white"></span>
        <thead>
        <tr>
            <th scope="col">Request ID</th>
            <th scope="col">First</th>
            <th scope="col">Last</th>
            <th scope="col">Amount</th>
            <th scope="col">Reason</th>
            <th scope="col">Employee ID</th>
            <th scope="col">Status</th>
            <th>Approve</th>
            <th>Deny</th>

        </tr>
        </thead>
        <tbody>
        <%  %>
         <%

                      List<ExpReimbursementReq> allRec = (List<ExpReimbursementReq>) request.getAttribute("all-Requests");
                           for(ExpReimbursementReq requez:allRec){

                   %>
                 <tr>
                     <td><%=requez.getId()%></td>
                     <td><%=requez.getEmployee().getFirstName()%></td>
                     <td><%=requez.getEmployee().getLastName()%></td>
                     <td><%=requez.getAmount()%></td>
                     <td><%=requez.getReimReason()%></td>
                     <td><%=requez.getEmployee().getEmp_ID()%></td>
                     <td><%=requez.getStatus()%></td>
                     <td><a href="approve-request?id=<%=requez.getId()%>"><i style="cursor: pointer" class="fa-solid fa-thumbs-up"></i></a></td>
                     <td><a href="deny-request?id=<%=requez.getId()%>"><i style="cursor: pointer" class="fa-solid fa-thumbs-down"></i></a></td>

                 </tr>
                    <%
                            }
                     %>
        </tbody>
    </table>
</div>


<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>