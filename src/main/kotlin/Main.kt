import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory


fun main(args: Array<String>) {
    println("Request setup:")

    val baseUrl = "https://64f9d8634098a7f2fc151107.mockapi.io"
    val retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(JacksonConverterFactory.create()).build()
    val service = retrofit.create(UserAPI::class.java)
    val request = service.userList()

    println("Call API request:")
    request.enqueue(object: Callback<List<User>> {
        override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
            val allUser = response.body()
            for (u in allUser!!)
                println("User : ${u._id} | name : ${u.name} | email : ${u.email} | password : ${u.password}")

        }

        override fun onFailure(call: Call<List<User>>, t: Throwable) {
            throw t
        }
    })


}



