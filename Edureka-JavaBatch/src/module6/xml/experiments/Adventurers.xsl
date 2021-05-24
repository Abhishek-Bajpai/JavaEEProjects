<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="Adventurers">
		<html>
			<body>
				<h2>Adventurers List</h2>
				<table border="1">
					<tr bgcolor="lightblue">
						<th>Full Name</th>
						<th>From</th>
						<th>Profession</th>
					</tr>
					<xsl:for-each select= "Adventurer">
					<tr>
						<td><xsl:value-of select="Name"/></td>
						<td><xsl:value-of select="from"/></td>
						<td><xsl:value-of select="Profession"/></td>
					</tr>	
					</xsl:for-each>
				</table>
			</body>
		</html>

	</xsl:template>
</xsl:stylesheet>