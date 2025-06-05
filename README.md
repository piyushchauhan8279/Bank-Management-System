💳 Bank Management System

A desktop-based banking application designed to simulate the core functionalities of a traditional bank. Built using Java (AWT & Swing) for the user interface and MySQL for backend data storage, this project provides a seamless experience for managing bank accounts and performing essential transactions.

🗓️ Project Duration: December 2024 – January 2025

✨ Key Features
🔐 Secure Login System
Card number and PIN-based authentication to ensure account safety.

🧾 User-Friendly Interface
Clean and intuitive UI with interactive forms for personal and account details during the sign-up process.

💰 Core Banking Operations
Deposit money
Withdraw money
Check account balance
View transaction history via a Mini Statement
Change PIN securely
Perform Quick Transactions using the Fast Cash feature

🛠️ Technologies Used
🎯 Frontend
Java AWT & Swing
Used for designing a responsive and interactive graphical user interface.

🗄️ Backend
MySQL
Handles storage of customer information, account data, and transaction history.

📁 Project Structure

BankManagementSystem/
│
├── src/
│   ├── Login.java
│   ├── Signup.java
│   ├── Dashboard.java
│   ├── Deposit.java
│   ├── Withdraw.java
│   ├── MiniStatement.java
│   ├── ChangePIN.java
│   └── FastCash.java
│
├── db/
│   └── schema.sql  // SQL script for MySQL database setup
│
└── README.md

⚙️ Setup Instructions

Clone the Repository
git clone https://github.com/your-username/bank-management-system.git
cd bank-management-system

Set Up MySQL Database
Create a new database (e.g., bank_db)
Import the schema.sql file to set up required tables

Configure JDBC Connection
In your Java files, update the database connection string with your MySQL credentials:

String url = "jdbc:mysql://localhost:3306/bank_db";
String username = "your_username";
String password = "your_password";

Run the Application
Compile and run the Java files via an IDE (e.g., IntelliJ IDEA, Eclipse) or terminal

📌 Future Enhancements

Add email/SMS notifications for transactions
Implement account types (Savings, Current)
Add admin module to manage all accounts




