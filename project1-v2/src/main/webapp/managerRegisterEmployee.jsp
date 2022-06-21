<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="main.css">
    <title>Employee Registration</title>
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
                    <a class="nav-link" href="managerViewAllReimbursements.html">All Reimbursements</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="managerRegisterEmployee.html">Register New Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Logout</a>
                </li>
            </ul>
            <form class="d-flex ml-auto" role="login">
                <input class="form-control me-2" type="email" placeholder="Email Address" aria-label="email">
                <input class="form-control me-2" type="password" placeholder="Password" aria-label="password">
                <button class="btn btn-outline-secondary" type="submit">Login</button>
            </form>
        </div>
    </div>
</nav>

<div class="jumbotron">
    <h1 class="display-4">Register an Employee</h1>
</div>

<div class="container">
    <div class="row" id="projectSummary">
        <h1>New Employee Registration</h1>
        <p class="lead">Below you will find the manager's form that allows new employee registration.</p>
    </div>
</div>

<div class="container">
    <div class="mb-3">
        <label for="inputFirstName" class="form-label">First Name</label>
        <input type="text" class="form-control" id="inputFirstName">
    </div>
    <div class="mb-3">
        <label for="inputLastName" class="form-label">Last Name</label>
        <input type="text" class="form-control" id="inputLastName">
    </div>
    <div class="mb-3">
        <label for="inputDob" class="form-label">Date of Birth</label>
        <input type="text" class="form-control" id="inputDob" placeholder="MM/DD/YYYY">
    </div>
    <div class="mb-3">
        <label for="inputAddress" class="form-label">Address</label>
        <input type="text" class="form-control" id="inputAddress" placeholder="Ex: 123 Main Street, Daytona Beach, FL">
    </div>
    <div class="mb-3">
        <label for="inputPhoneNum" class="form-label">Phone Number</label>
        <input type="text" class="form-control" id="inputPhoneNum" placeholder="(XXX) XXX-XXXX">
    </div>
    <div class="mb-3">
        <label for="inputEmail" class="form-label">Email</label>
        <input type="email" class="form-control" id="inputEmail">
    </div>
    <button type="button" class="btn btn-outline-secondary btn-lg btn-space">Submit</button>
</div>




<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>