package com.example.faruk.hci_ib130051.services;

import com.example.faruk.hci_ib130051.bus.OttoBus;
import com.example.faruk.hci_ib130051.models.Korisnik;
import com.example.faruk.hci_ib130051.models.KorisnikLogin;
import com.example.faruk.hci_ib130051.models.Opstina;
import com.example.faruk.hci_ib130051.models.Poruka;
import com.example.faruk.hci_ib130051.models.Proizvod;
import com.example.faruk.hci_ib130051.models.ProizvodRequest;
import com.example.faruk.hci_ib130051.models.ProizvodResponse;
import com.example.faruk.hci_ib130051.models.SendMessageReq;
import com.example.faruk.hci_ib130051.network.RestFactoryClient;
import com.example.faruk.hci_ib130051.network.events.GetDolaznePorukeResponse;
import com.example.faruk.hci_ib130051.network.events.GetKorisniciByParamsResponse;
import com.example.faruk.hci_ib130051.network.events.GetKorisniciResponse;
import com.example.faruk.hci_ib130051.network.events.GetOpstineResponse;
import com.example.faruk.hci_ib130051.network.events.GetProizvodiByParamsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FactoryService {

    public static void getOpstine() {
        RestFactoryClient.getfApiService().getOpstina().enqueue(new Callback<List<Opstina>>() {
            @Override
            public void onResponse(Call<List<Opstina>> call, Response<List<Opstina>> response) {
                GetOpstineResponse getOpstineResponse = new GetOpstineResponse();
                getOpstineResponse.setOpstinas(response.body());

                if (getOpstineResponse == null) {
                    return;
                }

                OttoBus.getInstance().post(getOpstineResponse);
            }

            @Override
            public void onFailure(Call<List<Opstina>> call, Throwable t) {
                GetOpstineResponse getOpstineResponse = new GetOpstineResponse();
                getOpstineResponse.setErrorMessage(t.getMessage());

                if (getOpstineResponse == null) {
                    return;
                }

                OttoBus.getInstance().post(getOpstineResponse);
            }
        });
    }

    public static void getKorisnici() {
        RestFactoryClient.getfApiService().getKorisnici().enqueue(new Callback<List<Korisnik>>() {
            @Override
            public void onResponse(Call<List<Korisnik>> call, Response<List<Korisnik>> response) {
                GetKorisniciResponse getKorisniciResponse = new GetKorisniciResponse();
                getKorisniciResponse.setKorisnikList(response.body());

                if (getKorisniciResponse == null) {
                    return;
                }

                OttoBus.getInstance().post(getKorisniciResponse);
            }

            @Override
            public void onFailure(Call<List<Korisnik>> call, Throwable t) {
                GetKorisniciResponse getKorisniciResponse = new GetKorisniciResponse();
                getKorisniciResponse.setErrorMessage(t.getMessage());

                if (getKorisniciResponse == null) {
                    return;
                }

                OttoBus.getInstance().post(getKorisniciResponse);
            }
        });
    }

    public static void getKorisnik(String username) {
        RestFactoryClient.getfApiService().getKorisnik(username).enqueue(new Callback<KorisnikLogin>() {
            @Override
            public void onResponse(Call<KorisnikLogin> call, Response<KorisnikLogin> response) {
                KorisnikLogin korisnik;

                if (response.body() != null) {
                    korisnik = response.body();
                }
                else {
                    korisnik = new KorisnikLogin();
                    korisnik.setErrorMessage(response.code() + " " + response.message());
                }

                if (korisnik == null) {
                    return;
                }

                OttoBus.getInstance().post(korisnik);
            }

            @Override
            public void onFailure(Call<KorisnikLogin> call, Throwable t) {
                KorisnikLogin korisnik = new KorisnikLogin();
                korisnik.setErrorMessage(t.getMessage());

                if (korisnik == null) {
                    return;
                }

                OttoBus.getInstance().post(korisnik);
            }
        });
    }

    public static void postKorisnik(String model) {
        RestFactoryClient.getfApiService().postKorisnik(model).enqueue(new Callback<Korisnik>() {
            @Override
            public void onResponse(Call<Korisnik> call, Response<Korisnik> response) {
                Korisnik korisnik;
                if (response.body() != null) {
                    korisnik = response.body();
                }
                else {
                    korisnik = new Korisnik();
                    korisnik.setErrorMessage(response.code() + " " + response.message());
                }

                if (korisnik == null) {
                    return;
                }

                OttoBus.getInstance().post(korisnik);
            }

            @Override
            public void onFailure(Call<Korisnik> call, Throwable t) {
                Korisnik korisnik = new Korisnik();
                korisnik.setErrorMessage(t.getMessage());

                if (korisnik == null) {
                    return;
                }

                OttoBus.getInstance().post(korisnik);
            }
        });
    }

    public static void getKorisniciByParams(String naziv, Boolean isTrgovina, int logiraniId) {
        RestFactoryClient.getfApiService().getKorisnici(naziv, isTrgovina, logiraniId).enqueue(new Callback<List<Korisnik>>() {
            @Override
            public void onResponse(Call<List<Korisnik>> call, Response<List<Korisnik>> response) {
                GetKorisniciByParamsResponse getKorisniciByParamsResponse = new GetKorisniciByParamsResponse();

                if (response.body() != null) {
                    getKorisniciByParamsResponse.setKorisnikList(response.body());
                }
                else {
                    getKorisniciByParamsResponse.setErrorMessage(response.code() + " " + response.message());
                }

                if (getKorisniciByParamsResponse == null) {
                    return;
                }

                OttoBus.getInstance().post(getKorisniciByParamsResponse);
            }

            @Override
            public void onFailure(Call<List<Korisnik>> call, Throwable t) {
                GetKorisniciByParamsResponse getKorisniciByParamsResponse = new GetKorisniciByParamsResponse();
                getKorisniciByParamsResponse.setErrorMessage(t.getMessage());

                if (getKorisniciByParamsResponse == null) {
                    return;
                }

                OttoBus.getInstance().post(getKorisniciByParamsResponse);
            }
        });
    }

    public static void getProizvodiByParams(String naziv, int kategorijaId, int logiraniId) {
        RestFactoryClient.getfApiService().getProizvodi(naziv, kategorijaId, logiraniId).enqueue(new Callback<List<Proizvod>>() {
            @Override
            public void onResponse(Call<List<Proizvod>> call, Response<List<Proizvod>> response) {
                GetProizvodiByParamsResponse getProizvodiByParamsResponse = new GetProizvodiByParamsResponse();

                if (response.body() != null) {
                    getProizvodiByParamsResponse.setProizvodList(response.body());
                }
                else {
                    getProizvodiByParamsResponse.setErrorMessage(response.code() + " " + response.message());
                }

                if (getProizvodiByParamsResponse == null) {
                    return;
                }

                OttoBus.getInstance().post(getProizvodiByParamsResponse);
            }

            @Override
            public void onFailure(Call<List<Proizvod>> call, Throwable t) {
                GetProizvodiByParamsResponse getProizvodiByParamsResponse = new GetProizvodiByParamsResponse();
                getProizvodiByParamsResponse.setErrorMessage(t.getMessage());

                OttoBus.getInstance().post(getProizvodiByParamsResponse);
            }
        });
    }

    public static void getAktivniProizvodi(int kategorijaId, int logiraniId) {
        RestFactoryClient.getfApiService().getAktivniProizvodi(kategorijaId, logiraniId).enqueue(new Callback<List<Proizvod>>() {
            @Override
            public void onResponse(Call<List<Proizvod>> call, Response<List<Proizvod>> response) {
                GetProizvodiByParamsResponse getProizvodiByParamsResponse = new GetProizvodiByParamsResponse();

                if (response.body() != null) {
                    getProizvodiByParamsResponse.setAktivni(true);
                    getProizvodiByParamsResponse.setProizvodList(response.body());
                }
                else {
                    getProizvodiByParamsResponse.setErrorMessage(response.code() + " " + response.message());
                }

                if (getProizvodiByParamsResponse == null) {
                    return;
                }

                OttoBus.getInstance().post(getProizvodiByParamsResponse);
            }

            @Override
            public void onFailure(Call<List<Proizvod>> call, Throwable t) {
                GetProizvodiByParamsResponse getProizvodiByParamsResponse = new GetProizvodiByParamsResponse();
                getProizvodiByParamsResponse.setErrorMessage(t.getMessage());

                if (getProizvodiByParamsResponse == null) {
                    return;
                }

                OttoBus.getInstance().post(getProizvodiByParamsResponse);
            }
        });
    }

    public static void getNeAktivniProizvodi(int kategorijaId, int logiraniId) {
        RestFactoryClient.getfApiService().getNeAktivniProizvodi(kategorijaId, logiraniId).enqueue(new Callback<List<Proizvod>>() {
            @Override
            public void onResponse(Call<List<Proizvod>> call, Response<List<Proizvod>> response) {
                GetProizvodiByParamsResponse getProizvodiByParamsResponse = new GetProizvodiByParamsResponse();

                if (response.body() != null) {
                    getProizvodiByParamsResponse.setProizvodList(response.body());
                }
                else {
                    getProizvodiByParamsResponse.setErrorMessage(response.code() + " " + response.message());
                }

                if (getProizvodiByParamsResponse == null) {
                    return;
                }

                OttoBus.getInstance().post(getProizvodiByParamsResponse);
            }

            @Override
            public void onFailure(Call<List<Proizvod>> call, Throwable t) {
                GetProizvodiByParamsResponse getProizvodiByParamsResponse = new GetProizvodiByParamsResponse();
                getProizvodiByParamsResponse.setErrorMessage(t.getMessage());

                if (getProizvodiByParamsResponse == null) {
                    return;
                }

                OttoBus.getInstance().post(getProizvodiByParamsResponse);
            }
        });
    }

    public static void sendMessage(SendMessageReq poruka) {
        RestFactoryClient.getfApiService().sendMessage(poruka).enqueue(new Callback<Poruka>() {
            @Override
            public void onResponse(Call<Poruka> call, Response<Poruka> response) {
                Poruka poruka;

                if (response.body() != null) {
                    poruka = response.body();
                }
                else {
                    poruka = new Poruka();
                    poruka.setErrorMessage(response.code() + " " + response.message());
                }

                if (poruka == null) {
                    return;
                }

                OttoBus.getInstance().post(poruka);
            }

            @Override
            public void onFailure(Call<Poruka> call, Throwable t) {
                Poruka poruka1 = new Poruka();
                poruka1.setErrorMessage(t.getMessage());

                if (poruka1 == null) {
                    return;
                }

                OttoBus.getInstance().post(poruka1);
            }
        });
    }

    public static void getDolaznePoruke(int korisnikId) {
        RestFactoryClient.getfApiService().getDolaznePoruke(korisnikId).enqueue(new Callback<List<Poruka>>() {
            @Override
            public void onResponse(Call<List<Poruka>> call, Response<List<Poruka>> response) {
                GetDolaznePorukeResponse getDolaznePorukeResponse = new GetDolaznePorukeResponse();

                if (response.body() != null) {
                    getDolaznePorukeResponse.setPorukaList(response.body());
                }
                else {
                    getDolaznePorukeResponse = new GetDolaznePorukeResponse();
                    getDolaznePorukeResponse.setErrorMessage(response.code() + " " + response.message());
                }

                if (getDolaznePorukeResponse == null) {
                    return;
                }

                OttoBus.getInstance().post(getDolaznePorukeResponse);
            }

            @Override
            public void onFailure(Call<List<Poruka>> call, Throwable t) {
                GetDolaznePorukeResponse getDolaznePorukeResponse = new GetDolaznePorukeResponse();
                getDolaznePorukeResponse.setErrorMessage(t.getMessage());

                if (getDolaznePorukeResponse == null) {
                    return;
                }

                OttoBus.getInstance().post(getDolaznePorukeResponse);
            }
        });
    }

    public static void updateProizvod(int proizvodId, boolean aktivan) {
        RestFactoryClient.getfApiService().updateProizvod(proizvodId, aktivan).enqueue(new Callback<ProizvodResponse>() {
            @Override
            public void onResponse(Call<ProizvodResponse> call, Response<ProizvodResponse> response) {
                ProizvodResponse proizvod1;

                if (response.body() != null) {
                    proizvod1 = response.body();
                }
                else {
                    proizvod1 = new ProizvodResponse();
                    proizvod1.setErrorMessage(response.code() + " " + response.message());
                }

                if (proizvod1 == null) {
                    return;
                }

                OttoBus.getInstance().post(proizvod1);
            }

            @Override
            public void onFailure(Call<ProizvodResponse> call, Throwable t) {
                ProizvodResponse proizvod1 = new ProizvodResponse();
                proizvod1.setErrorMessage(t.getMessage());

                if (proizvod1 == null) {
                    return;
                }

                OttoBus.getInstance().post(proizvod1);
            }
        });
    }

}
