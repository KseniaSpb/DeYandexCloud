//создание витрины с помощью спарка

val datamart = sales
	.join(products, sales("s_product_id") === products("p_product_id")).join(orders, sales("s_order_id") === orders("o_order_id"))
	.join(customers, orders("o_customer_id") === customers("c_customer_id")).join(cities, customers("cus_city_id") === cities("c_city_id"))
	.select(col("c_city_id"), col("city_name"), col("country"), col("region"), col("p_product_id"), col("category"),
	 col("sub_category"), 	col("product_name"), col("c_customer_id"), col("customer_name"), col("segment"), col("order_date"),
	 col("ship_date"),  col("order_priority"), col("o_order_id"), col("sale_id"), col("quantity"), col("sales"),
	 col("profit"),  to_timestamp(col("order_date")).as("date")).withColumn("year", year(col("date")))
	.withColumn("month", month(col("date"))).write.mode("overwrite").saveAsTable("store101.datamart")

//загрузка витрины в базу хранилища

val datamart = spark.table("store101.datamart")
	.write.format("jdbc").option("url", "jdbc:postgresql://########.rw.mdb.yandexcloud.net:6432/store101dwh")
	.option("driver", "org.postgresql.Driver")
	.option("dbtable", "store.datamart")
	.option("user", "########")
	.option("password", "########")
	.option("ssl", "True")
	.option("sslmode", "require" ).save()
