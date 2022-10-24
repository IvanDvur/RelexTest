Input: [-1, 2, 3, 10, 0, -2, 3, 4, 22, 7, -1]

Request
GET http://localhost:8080/api/makeoperation
Header: accept:application/json
Body:
{
    "path":"D:/test.txt",
    "operation":"get_max"
}
Response:
{
    "result": "22"
}


Request
GET http://localhost:8080/api/makeoperation/get_ascend
Header: accept:application/json
Body:
{
    "path":"D:/test.txt"
}
Response:
{
    "result": "[[-1, 2, 3, 10], [-2, 3, 4, 22]]"
}


Request
GET http://localhost:8080/api/makeoperation/get_descend
Header: accept:application/xml
Body:
{
    "path":"D:/test.txt"
}
Response:
<ResponseDto>
    <result>[[10, 0, -2], [22, 7, -1]]</result>
</ResponseDto>


Request
GET http://localhost:8080/api/makeoperation/get_min
Header: accept:application/xml
Body:
{
    "path":"D:/test.txt",
    "operation":"get_min"
}
Response:
<ResponseDto>
    <result>Error: file not found or conflict of requests</result>
</ResponseDto>


Request:
POST http://localhost:8080/api/upload
Header: Content-type: multipart/form-data, accept:application/json
Body:
	file: 10m.txt
Response:
{
    "max_value": "49999978",
    "min_value": "-49999996",
    "average": "7364.418442641844",
    "mediane": "25216",
    "ascendingSequences": "[[-48190694, -47725447, -43038241, -20190291, -17190728, -6172572, 8475960, 25205909, 48332507, 48676185]]",
    "descendingSequences": "[[47689379, 42381213, 30043880, 12102356, -4774057, -5157723, -11217378, -23005285, -23016933, -39209115, -49148762]]"
}