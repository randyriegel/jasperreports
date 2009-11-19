/*
 * JasperReports - Free Java Reporting Library.
 * Copyright (C) 2001 - 2009 Jaspersoft Corporation. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of JasperReports.
 *
 * JasperReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JasperReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with JasperReports. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.jasperreports.crosstabs.design;

import net.sf.jasperreports.crosstabs.base.JRBaseCrosstabBucket;
import net.sf.jasperreports.engine.JRConstants;
import net.sf.jasperreports.engine.JRExpression;
import net.sf.jasperreports.engine.design.JRDesignExpression;
import net.sf.jasperreports.engine.design.events.JRChangeEventsSupport;
import net.sf.jasperreports.engine.design.events.JRPropertyChangeSupport;

/**
 * Implementation of {@link net.sf.jasperreports.crosstabs.JRCrosstabBucket corsstab group bucket}
 * to be used for report designing.
 * 
 * @author Lucian Chirita (lucianc@users.sourceforge.net)
 * @version $Id$
 */
public class JRDesignCrosstabBucket extends JRBaseCrosstabBucket implements JRChangeEventsSupport
{
	private static final long serialVersionUID = JRConstants.SERIAL_VERSION_UID;

	public static final String PROPERTY_ORDER_BY_EXPRESSION = "orderByExpression";

	public static final String PROPERTY_COMPARATOR_EXPRESSION = "comparatorExpression";

	public static final String PROPERTY_EXPRESSION = "expression";

	public static final String PROPERTY_ORDER = "order";

	
	/**
	 * Creates a crosstab group bucket.
	 */
	public JRDesignCrosstabBucket()
	{
		super();
	}

	
	/**
	 * Sets the expression that provides order by values for group buckets.
	 * 
	 * @param orderByExpression the expression that provides order by values
	 * for group buckets
	 * @see #getOrderByExpression()
	 */
	public void setOrderByExpression(JRExpression orderByExpression)
	{
		Object old = this.orderByExpression;
		this.orderByExpression = orderByExpression;
		getEventSupport().firePropertyChange(PROPERTY_ORDER_BY_EXPRESSION, 
				old, this.orderByExpression);
	}

	
	/**
	 * Sets the comparator expression.
	 * <p>
	 * The expressions's type should be compatible with {@link java.util.Comparator java.util.Comparator}.
	 * 
	 * @param comparatorExpression the comparator expression
	 * @see net.sf.jasperreports.crosstabs.JRCrosstabBucket#getComparatorExpression()
	 */
	public void setComparatorExpression(JRExpression comparatorExpression)
	{
		Object old = this.comparatorExpression;
		this.comparatorExpression = comparatorExpression;
		getEventSupport().firePropertyChange(PROPERTY_COMPARATOR_EXPRESSION, old, this.comparatorExpression);
	}

	
	/**
	 * Sets the grouping expression.
	 * 
	 * @param expression the grouping expression
	 * @see net.sf.jasperreports.crosstabs.JRCrosstabBucket#getExpression()
	 */
	public void setExpression(JRDesignExpression expression)
	{
		Object old = this.expression;
		this.expression = expression;
		getEventSupport().firePropertyChange(PROPERTY_EXPRESSION, old, this.expression);
	}

	
	/**
	 * Sets the sorting type.
	 * 
	 * @param order one of
	 * <ul>
	 * 	<li>{@link net.sf.jasperreports.crosstabs.fill.calculation.BucketDefinition#ORDER_ASCENDING Bucket.ORDER_ASCENDING}</li>
	 * 	<li>{@link net.sf.jasperreports.crosstabs.fill.calculation.BucketDefinition#ORDER_DESCENDING Bucket.ORDER_DESCENDING}</li>
	 * </ul>
	 * @see net.sf.jasperreports.crosstabs.JRCrosstabBucket#getOrder()
	 */
	public void setOrder(byte order)
	{
		byte old = this.order;
		this.order = order;
		getEventSupport().firePropertyChange(PROPERTY_ORDER, old, this.order);
	}
	
	private transient JRPropertyChangeSupport eventSupport;
	
	public JRPropertyChangeSupport getEventSupport()
	{
		synchronized (this)
		{
			if (eventSupport == null)
			{
				eventSupport = new JRPropertyChangeSupport(this);
			}
		}
		
		return eventSupport;
	}
}
