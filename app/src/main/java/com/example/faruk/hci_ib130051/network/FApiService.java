package com.example.faruk.hci_ib130051.network;

import com.example.faruk.hci_ib130051.models.Korisnik;
import com.example.faruk.hci_ib130051.models.KorisnikLogin;
import com.example.faruk.hci_ib130051.models.Opstina;
import com.example.faruk.hci_ib130051.models.Poruka;
import com.example.faruk.hci_ib130051.models.Proizvod;
import com.example.faruk.hci_ib130051.models.ProizvodRequest;
import com.example.faruk.hci_ib130051.models.ProizvodResponse;
import com.example.faruk.hci_ib130051.models.SendMessageReq;
import com.example.faruk.hci_ib130051.network.events.GetDolaznePorukeResponse;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface FApiService {

    @GET("/plesk-site-preview/hci211.app.fit.ba/5.189.152.86/api/Korisnik")
    Call<List<Korisnik>> getKorisnici();

    @GET("/plesk-site-preview/hci211.app.fit.ba/5.189.152.86/api/Korisnik/GetKorisnik/{username}")
    Call<KorisnikLogin> getKorisnik(@Path("username") String username);

    @GET("/plesk-site-preview/hci211.app.fit.ba/5.189.152.86/api/Korisnik/GetKorisniciByParams/{Naziv}/{IsTrgovina}/{LogiraniId}")
    Call<List<Korisnik>> getKorisnici(@Path("Naziv") String naziv, @Path("IsTrgovina") Boolean isTrgovina, @Path("LogiraniId") int logiraniId);

    @POST("Korisnik/NoviKorisnik")
    Call<Korisnik> postKorisnik(@Body String model);

    @GET("/plesk-site-preview/hci211.app.fit.ba/5.189.152.86/api/Proizvod/GetProizvodiByParams/{Naziv}/{KategorijaId}/{LogiraniId}")
    Call<List<Proizvod>> getProizvodi(@Path("Naziv") String naziv, @Path("KategorijaId") int kategorijaId, @Path("LogiraniId") int logiraniId);

    @GET("/plesk-site-preview/hci211.app.fit.ba/5.189.152.86/api/Proizvod/GetAktivneByParams/{KorisnikId}/{KategorijaId}")
    Call<List<Proizvod>> getAktivniProizvodi(@Path("KategorijaId") int kategorijaId, @Path("KorisnikId") int logiraniId);

    @GET("/plesk-site-preview/hci211.app.fit.ba/5.189.152.86/api/Proizvod/GetNeaktivneByParamsTrgovina/{KorisnikId}/{KategorijaId}")
    Call<List<Proizvod>> getNeAktivniProizvodi(@Path("KategorijaId") int kategorijaId, @Path("KorisnikId") int logiraniId);

    @POST("/plesk-site-preview/hci211.app.fit.ba/5.189.152.86/api/Proizvod/ProizvodAktivnost/{Id}/{IsAktivan}")
    Call<ProizvodResponse> updateProizvod(@Path("Id") int proizvodId, @Path("IsAktivan") boolean isAktivan);


    @GET("/plesk-site-preview/hci211.app.fit.ba/5.189.152.86/api/Korisnik/GetOpstine")
    Call<List<Opstina>> getOpstina();


    @POST("/plesk-site-preview/hci211.app.fit.ba/5.189.152.86/api/Poruka")
    Call<Poruka> sendMessage(@Body SendMessageReq poruka);

    @GET("/plesk-site-preview/hci211.app.fit.ba/5.189.152.86/api/Poruka/GetDolazne/{KorisnikId}")
    Call<List<Poruka>> getDolaznePoruke(@Path("KorisnikId") int korisnikId);

}
