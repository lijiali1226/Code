<table align="center" border="1" width="500">
	<caption><h1>计算器</h1></caption>
	<form action="calculator.php">
		<tr>
			<td>
				<input type="text" size="5" name="num1">
			</td>
			<td>
				<select name="operator">
					<option value="+">+</option>
					<option value="-">-</option>
					<option value="x">x</option>
					<option value="/">/</option>
					<option value="%">%</option>
				</select>
			</td>
			<td>
				<input type="text" size="5" name="num2">
			</td>
			<td>
				<input type="submit" name="sub" value="计算">
			</td>
		</tr>
		<?php
		if(isset($_GET["sub"])){
			echo '<tr><td colspan="5">';
			$num1=$_GET["num1"];
			$op=$_GET["operator"];
			$num2=$_GET["num2"];
			switch($op)
			{
				case '+':
				$result=$num1+$num2;
				break;
				case '-':
				$result=$num1-$num2;
				break;
				case 'x':
				$result=$num1*$num2;
				break;
				case '/':
				$result=$num1/$num2;
				break;
				case '%':
				$result=$num1%$num2;
				break;
			}
			
			echo "结果:".$result;
			echo '</td></tr>';
		}
		?>
	</form>
</table>
</body>
</html>