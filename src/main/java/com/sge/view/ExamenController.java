package com.sge.view;

import com.sge.model.Examen;
import com.sge.service.ExamenService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
@Getter
@Setter
public class ExamenController implements Serializable {

    @Autowired
    private ExamenService examenService;

    private List<Examen> examens;
    private Examen examen = new Examen();

    @PostConstruct
    public void init() {
        examens = examenService.findAll();
    }

    public void save() {
        examenService.save(examen);
        examens = examenService.findAll(); // Refresh the list
        examen = new Examen(); // Reset the form
    }
}
