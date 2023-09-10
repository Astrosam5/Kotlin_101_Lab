import retrofit2.Call
import retrofit2.http.GET

interface UserAPI{

    @GET("/user")
    fun userList(): Call<List<User>>

}