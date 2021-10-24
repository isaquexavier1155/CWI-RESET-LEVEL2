package br.com.cwi.reset.isaquexavierdossantos.service;

import  br.com.cwi.reset.isaquexavierdossantos.FakeDatabase ;
import  br.com.cwi.reset.isaquexavierdossantos.model.Estudio ;
import br.com.cwi.reset.isaquexavierdossantos.repository.AtorRepository;
import br.com.cwi.reset.isaquexavierdossantos.repository.EstudioRepository;
import br.com.cwi.reset.isaquexavierdossantos.request.EstudioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  java.util.ArrayList ;
import  java.util.List ;

@Service
public  class  EstudioService {
    @Autowired
    private EstudioRepository repository;

    /*private  FakeDatabase fakeDatabase;

    public  EstudioService ( final  FakeDatabase  fakeDatabase ) {
        this . fakeDatabase = fakeDatabase;
    }*/

    public  void  criarEstudio ( EstudioRequest estudioRequest ) throws  Exception {

    }

    public  List < Estudio >  consultarEstudios ( String  filtroNome ) throws  Exception {
        List < Estudio > estudios =  new  ArrayList <> ();
        return estudios;
    }

    public  Estudio  consultarEstudio ( Integer  id ) throws  Exception {
        return  null ;
    }
}