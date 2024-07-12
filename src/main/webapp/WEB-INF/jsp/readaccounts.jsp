<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Bank Accounts</title>
    <style>
        body {
            background-image: url('https://i.pinimg.com/736x/36/66/27/366627a1b7f9b9cec30267455f6a9131.jpg'); /* replace with your background image */
            background-size: 100% 100vh; /* adjust the image size to fit the full screen */
            background-position: center;
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            width: 80%;
            text-align: center;
            margin: 0 auto;
        }
        h1 {
            color: #333;
            background-color: none; /* optional: add a background color to the heading */
            padding: 10px; /* optional: add some padding to the heading */
            font-size: 24px; /* optional: adjust the font size */
            font-weight: bold; /* optional: make the font bold */
            margin-top: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f0f0f0;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        button {
            background-color: #4CAF50;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background-color: #3e8e41;
        }
        .search-form {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Bank Accounts</h1>
        <form class="search-form">
            <input type="text" id="search-id" name="search-id" placeholder="Enter ID to search">
            <button type="submit">Search</button>
        </form>
        <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Balance</th>
                <th>Account No</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            <!-- loop through the list of bank accounts and display them here -->
            <c:forEach var="account" items="${accounts}">
                <tr>
                    <td>${account.id}</td>
                    <td>${account.name}</td>
                    <td>${account.balance}</td>
                    <td>${account.accountNo}</td>
                    <td><button onclick="location.href='/update-account/${account.id}'">Update</button></td>
                    <td><button onclick="location.href='/delete-account/${account.id}'">Delete</button></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>