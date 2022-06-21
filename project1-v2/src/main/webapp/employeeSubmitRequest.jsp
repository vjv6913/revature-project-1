<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="main.css">
    <title>Reimbursement Request Form</title>
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
                    <a class="nav-link" href="reimbursements">Reimbursements</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="submitRequest">Submit a Request</a>
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
    <h1 class="display-4">Submit a Reimbursement Request</h1>
</div>

<div class="container">
    <div class="row" id="projectSummary">
        <h1>Expense Reimbursement Form</h1>
        <p class="lead">Please fill out the form below to send a request to your manager to be reimbursed for your expenses.</p>
    </div>
</div>

<div class="container">
    <div class="mb-3">
        <label for="inputReimbursementAmount" class="form-label">Expense Amount</label>
        <input type="text" class="form-control" id="inputReimbursementAmount">
    </div>
    <div class="mb-3">
        <label for="inputReimbursementReason" class="form-label">Reason for Expense</label>
        <input type="text" class="form-control" id="inputReimbursement Reason">
    </div>
    <div class="mb-3">
        <label for="inputLocalDateTime" class="form-label">Date and Time</label>
        <input type="text" class="form-control" id="inputLocalDateTime" placeholder="MM/DD/YYYY XX:XX AM or PM">
    </div>
    <div class="mb-3">
        <label for="inputFirstName" class="form-label">First Name</label>
        <input type="text" class="form-control" id="inputFirstName">
    </div>
    <div class="mb-3">
        <label for="inputLastName" class="form-label">Last Name</label>
        <input type="text" class="form-control" id="inputLastName">
    </div>
    <button type="button" class="btn btn-outline-secondary btn-lg btn-space">Submit</button>
</div>


<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>