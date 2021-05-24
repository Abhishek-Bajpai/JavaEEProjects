<xsl:for-each select="catalog/cd">
	<xsl:value-of select="title" />
	<xsl:choose>
		<xsl:when test="price > 10">
			<xsl:value-of select="artist" />
		</xsl:when>
		<xsl:otherwise>
			<xsl:value-of select="artist" />
		</xsl:otherwise>
	</xsl:choose>
</xsl:for-each>