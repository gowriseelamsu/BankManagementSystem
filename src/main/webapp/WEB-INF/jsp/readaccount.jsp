<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1>Bank Account</h1>
<table>
    <tr>
        <td><form:label path="accountHolderName">Name</form:label></td>
        <td><form:input path="accountHolderName" readonly="true" /></td>
    </tr>
    <tr>
        <td><form:label path="balance">Balance</form:label></td>
        <td><form:input path="balance" readonly="true" /></td>
    </tr>
    <tr>
        <td><form:label path="accountNumber">Account No</form:label></td>
        <td><form:input path="accountNumber" readonly="true" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <a href="/bank-accounts">Back to Bank Accounts</a>
        </td>
    </tr>
</table>