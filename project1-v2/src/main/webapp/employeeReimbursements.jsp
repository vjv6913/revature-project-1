<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="main.css">
    <title>Employee Reimbursements</title>
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
                <li class="nav-item">
                    <a class="nav-link active" href="employeeHome">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="reimbursements">Reimbursements</a>
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
    <h1 class="display-4">Reimbursement History</h1>
</div>

<div class="container">
    <div class="row" id="projectSummary">
        <h1>Reimbursement History Table</h1>
        <p class="lead">This table displays any current or past reimbursement expense tickets you have submitted. They will be approved or denied by your manager.</p>
    </div>
</div>

<div class="container">
    <table class="table table-bordered justify-content-center">
        <span class="border border-white"></span>
        <thead>
        <tr>
            <th scope="col">Reimbursement ID</th>
            <th scope="col">First</th>
            <th scope="col">Last</th>
            <th scope="col">Amount</th>
            <th scope="col">Reason</th>
            <th scope="col">Status</th>
            <th scope="col">Date and Time</th>
            <th scope="col">Employee</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">getReimbursementID</th>
            <td>getFirstName</td>
            <td>getLastName</td>
            <td>getAmount</td>
            <td>getReason</td>
            <td>getStatus</td>
            <td>getLocalDateTime</td>
            <td>getEmployeeID</td>
        </tr>
        </tbody>
    </table>
</div>



<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>