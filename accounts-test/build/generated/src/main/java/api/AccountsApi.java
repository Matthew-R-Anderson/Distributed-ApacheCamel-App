package api;

import util.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import domain.Account;
import domain.ErrorMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AccountsApi {
  /**
   * Create a new customer account.
   * Create a new customer account.
   * @param account  (required)
   * @return Call&lt;Account&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("accounts")
  Call<Account> createAccount(
    @retrofit2.http.Body Account account
  );

  /**
   * Get customer accounts.
   * Get the complete details for all accounts.
   * @return Call&lt;List&lt;Account&gt;&gt;
   */
  @GET("accounts")
  Call<List<Account>> getAccounts();
    

}
