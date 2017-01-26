package views;

import controllers.ManagementSystem;
import models.Auto;
import models.Persona;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Alexander Vashurin on 26.01.2017.
 */
public class MainFrameServlet extends HttpServlet
{
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Установка кодировки для принятия параметров
        req.setCharacterEncoding("UTF-8");
        int answer = 0;
        try {
            answer = checkAction(req);
        } catch (SQLException sql_e) {
            throw new IOException(sql_e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Тут надо сделать вызов другой формы, которая перенаправит сервлет
// на другую JSP для ввода данных о новом человеке
        if (answer == 1) {
            try {
                Persona s = new Persona();
                s.setPersonaId(0);
                s.setDateOfBirth(new Date());
                Collection autos = ManagementSystem.getInstance().getAutos();
                PersonaForm sForm = new PersonaForm();
                sForm.initFromPersona(s);
                sForm.setAutos(autos);
                req.setAttribute("persona", sForm);
                getServletContext().getRequestDispatcher("/PersonaForm.jsp").forward(req, resp);
                return;
            } catch (SQLException sql_e) {
                throw new IOException(sql_e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (answer == 2) {
            // Тут надо сделать вызов другой формы, которая перенаправит сервлет
            // на другую JSP для ввода данных о человекее
            try {
                if (req.getParameter("personaId") != null) {
                    int stId = Integer.parseInt(req.getParameter("personaId"));
                    Persona s = ManagementSystem.getInstance().getPersonById(stId);
                    Collection autos = ManagementSystem.getInstance().getAutos();
                    PersonaForm sForm = new PersonaForm();
                    sForm.initFromPersona(s);
                    sForm.setAutos(autos);
                    req.setAttribute("persona", sForm);
                    getServletContext().getRequestDispatcher("/PersonaForm.jsp").forward(req, resp);
                    return;
                }
            } catch (SQLException sql_e) {
                throw new IOException(sql_e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String gs = req.getParameter("autoId");
        String ys = req.getParameter("year");

        if (answer == 3) {
            // Здесь мы перемещаем стедунтов в другую группу
            String newGs = req.getParameter("newAutoId");
            String newYs = req.getParameter("newYear");
            try {
                Auto g = new Auto();
                g.setAutoId(Integer.parseInt(gs));
                Auto ng = new Auto();
                ng.setAutoId(Integer.parseInt(newGs));
                ManagementSystem.getInstance().movePersonsToAuto(g, Integer.parseInt(ys), ng, Integer.parseInt(newYs));
                // Теперь мы будем показывать группу, куда переместили
                gs = newGs;
                ys = newYs;
            } catch (SQLException sql_e) {
                throw new IOException(sql_e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int autoId = -1;
        if (gs != null) {
            autoId = Integer.parseInt(gs);
        }
        int year = Calendar.getInstance().get(Calendar.YEAR);
        if (ys != null) {
            year = Integer.parseInt(ys);
        }
        MainFrameForm form = new MainFrameForm();
        try {
            Collection autos = ManagementSystem.getInstance().getAutos();
            Auto g = new Auto();
            g.setAutoId(autoId);
            if (autoId == -1) {
                Iterator i = autos.iterator();
                g = (Auto) i.next();
            }
            Collection persons = ManagementSystem.getInstance().getPersonFromAuto(g, year);
            form.setAutoId(g.getAutoId());
            form.setYear(year);
            form.setAutos(autos);
            form.setPersons(persons);
        } catch (SQLException sql_e) {
            throw new IOException(sql_e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.setAttribute("form", form);
        getServletContext().getRequestDispatcher("/MainFrame.jspx").forward(req, resp);
    }

    // Здесь мы проверям какое действие нам надо сделать – и возвращаем ответ
    private int checkAction(HttpServletRequest req) throws Exception {
        if (req.getParameter("Add") != null) {
            return 1;
        }
        if (req.getParameter("Edit") != null) {
            return 2;
        }
        if (req.getParameter("MoveGroup") != null) {
            return 3;
        }
        if (req.getParameter("Delete") != null) {
            if (req.getParameter("personaId") != null) {
                Persona s = new Persona();
                s.setPersonaId(Integer.parseInt(req.getParameter("personaId")));
                ManagementSystem.getInstance().deletePersona(s);
            }
            return 0;
        }
        return 0;
    }

    // Переопределим стандартные методы
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

}
