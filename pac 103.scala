class Account(private var balance: Double) {

  def deposit(amount: Double): Unit = {
    require(amount > 0, "Deposit amount must be positive")
    balance += amount
    println(s"Deposited $$${amount}. Current balance: $$${balance}.")
  }

  def withdraw(amount: Double): Unit = {
    require(amount > 0, "Withdraw amount must be positive")
    if (amount <= balance) {
      balance -= amount
      println(s"Withdrew $$${amount}. Current balance: $$${balance}.")
    } else {
      println(s"Insufficient funds. Current balance: $$${balance}.")
    }
  }

  def transfer(amount: Double, toAccount: Account): Unit = {
    require(amount > 0, "Transfer amount must be positive")
    if (amount <= balance) {
      this.withdraw(amount) 
      toAccount.deposit(amount) 
      println(s"Transferred $$${amount} to the target account.")
    } else {
      println(s"Insufficient funds for transfer. Current balance: $$${balance}.")
    }
  }

  def getBalance: Double = balance

  override def toString: String = f"Account balance: $$${balance}%.2f"
}
object AccountTest extends App {
  
  val account1 = new Account(1000.0)
  val account2 = new Account(500.0)

   
  account1.deposit(200.0)   
  account1.withdraw(150.0)  
  account1.transfer(300.0, account2)   
   
  println(s"Account 1 balance: $$${account1.getBalance}")
  println(s"Account 2 balance: $$${account2.getBalance}")
}