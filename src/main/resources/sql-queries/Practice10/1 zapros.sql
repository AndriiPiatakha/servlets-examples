SELECT operators.name FROM operators_point
LEFT JOIN operators
ON operators.id = operators_point.operator_id
RIGHT JOIN points
ON points.id = operators_point.point_id
where points.region = 'east';