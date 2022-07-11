
<%@ page import = "java.util.List"%>
<%@ page import = "com.example.entity.Employee"%>

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
    <link rel="stylesheet" type="text/css" href="main.css">
    <title>Employee Information</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.html">
            <img src="images/VLZlogo2.png">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <%

            if(empl.getRole().toString().equals("EMPLOYEE")) {


            %>
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="employeeHome">Home</a>
            </li>
            <%
                        }else if(empl.getRole().toString().equals("MANAGER")){
            %>
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="managerHome.html">Home</a>
            </li>
            <%
                }
            %>

                <li class="nav-item">
                    <a class="nav-link" href="ViewReimbursement">Reimbursements</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="submitRequest">Submit a Request</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="employeeInfo">View Info</a>
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
    <h1 class="display-4">Employee Information</h1>
</div>

<div class="container">
    <div class="row" id="projectSummary">
        <h1>Employee Information Table</h1>
        <p class="lead">Below you will find your information within the table, pulled from a database using PostgreSQL.</p>
    </div>
</div>

<div class="container">
<table class="table table-bordered justify-content-center">
    <span class="border border-white"></span>
    <thead>
    <tr>
        <th scope="col">Employee ID</th>
        <th scope="col">First</th>
        <th scope="col">Last</th>
        <th scope="col">Date of Birth</th>
        <th scope="col">Address</th>
        <th scope="col">Phone Number</th>
        <th scope="col">Email</th>
    </tr>
    </thead>
    <tbody>

    <tr>
        <td><%=empl.getEmp_ID()%></td>
        <td><%=empl.getFirstName()%></td>
        <td><%=empl.getLastName()%></td>
        <td><%=empl.getBirthDate()%></td>
        <td><%=empl.getAddress()%></td>
        <td><%=empl.getPhoneNum()%></td>
        <td><%=empl.getEmail()%></td>
    </tr>
        <%

        %>
    </tbody>
</table>
</div>





<div class="d-flex align-items-center justify-content-center">
<p>
    <a class="btn btn-primary" data-toggle="collapse" href="#multiCollapseExample1" role="button" aria-expanded="false" aria-controls="multiCollapseExample1">Edit Personal Information</a>
    <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#multiCollapseExample2" aria-expanded="false" aria-controls="multiCollapseExample2">Reset Your Password</button>

</p>
</div>
<div class="row">
    <div class="col">
        <div class="collapse multi-collapse" id="multiCollapseExample1">
            <div class="display">
                <div class="d-flex align-items-center justify-content-center">

                    <div class="card">
                        <div class="card-header">Update Your Information</div>
                        <div class="card-body">
                            <form action="updateEmpInfo" method="post">
                                                <div>
                                                    <label class="form-label">First Name</label>
                                                    <input name="fname" class="form-control"/>
                                                </div>
                                                <div>
                                                    <label class="form-label">Last Name</label>
                                                    <input name="lname" class="form-control"/>
                                                </div>
                                                <div>
                                                    <label class="form-label">Birthdate</label>
                                                    <input name="birthdate" class="form-control"/>
                                                </div>
                                                <div>
                                                    <label class="form-label">Email</label>
                                                    <input name="email" class="form-control"/>
                                                </div>
                                                <div>
                                                    <label class="form-label">Phone Number</label>
                                                    <input name="phonenumber" class="form-control"/>
                                                </div>
                                                <div>
                                                    <label class="form-label">Address</label>
                                                    <input name="address" class="form-control"/>
                                                </div>
                                                <br/>
                                                <button class="btn btn-primary">Update Info</button>
                                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col">
        <div class="collapse multi-collapse" id="multiCollapseExample2">
            <div class="display">
                            <div class="d-flex align-items-center justify-content-center">

                                <div class="card">
                                    <div class="card-header" width=>Reset Password</div>
                                    <div class="card-body">
                                        <form action="resetPW" method="post">
                                                                                                    <div>
                                                                                                        <label class="form-label">Enter Current Password</label>
                                                                                                        <input type="password" name="currPW" class="form-control"/>
                                                                                                    </div>
                                                                                                    <div>
                                                                                                        <label class="form-label">Enter New Password</label>
                                                                                                        <input type="password" name="newPW" class="form-control"/>
                                                                                                    </div>
                                                                                                    <div>
                                                                                                        <label class="form-label">Re-Enter New Password</label>
                                                                                                        <input type="password" name="reNewPW" class="form-control"/>
                                                                                                    </div>
                                                                                                    <br/>
                                                                                                    <button class="btn btn-primary">Update Password</button>
                                                                                </form>

                                    </div>
                                </div>
                            </div>
                        </div>
        </div>
    </div>
</div>








<% for(int i=1; i<21; i++){%>
<br>
<%
}
%>


<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>