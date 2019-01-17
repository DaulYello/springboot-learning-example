package org.spring.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.common.ResultUtils;
import org.spring.springboot.common.ReturnDataFormat;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * 城市 Controller 实现 Restful HTTP 服务
 * <p>
 * Created by bysocket on 07/02/2017.
 */
@RestController
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    private CityService cityService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CityController.class);

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ReturnDataFormat findOneCity(Model model, @PathVariable("id") Long id) {
        try{
            ReturnDataFormat resultDate = ResultUtils.requestSuccess();
            City city = cityService.findCityById(id);
            resultDate.setData(city);
            return resultDate;
        }catch (Exception e){
            return ResultUtils.requestErro(e);
        }
        /*model.addAttribute("city", cityService.findCityById(id));
        return "city";*/
    }

    @RequestMapping(method = RequestMethod.GET)
    public ReturnDataFormat findAllCity() {

        try{
            ReturnDataFormat resultDate = ResultUtils.requestSuccess();
            List<City> cityList = cityService.findAllCity();
            resultDate.setData(cityList);
            return resultDate;
        }catch (Exception e){
            return ResultUtils.requestErro(e);
        }
        /*List<City> cityList = cityService.findAllCity();
        model.addAttribute("cityList",cityList);
        return "cityList";*/
    }

    @RequestMapping(value = "saveCity", method = RequestMethod.POST)
    public ReturnDataFormat saveCity(@RequestBody City city) {
        LOGGER.info("保存参数：");
        try{
            ReturnDataFormat resultDate = ResultUtils.requestSuccess();
            long result = cityService.addCity(city);
            LOGGER.info("返回的主键："+city.getId());
            resultDate.setData("保存成功！");
            return resultDate;
        }catch (Exception e){
            return ResultUtils.requestErro(e);
        }
    }

    @RequestMapping(value = "updateCity", method = RequestMethod.POST)
    public ReturnDataFormat updateCity(@RequestBody(required = false) City city) {
        LOGGER.info("修改参数：");
        try{
            ReturnDataFormat resultDate = ResultUtils.requestSuccess();
            long result = cityService.updateCity(city);
            LOGGER.info("影响的行数："+result);
            resultDate.setData("修改成功！");
            return resultDate;
        }catch (Exception e){
            return ResultUtils.requestErro(e);
        }
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ReturnDataFormat deleteCity(@RequestParam Long id) {
        LOGGER.info("删除数据id："+id);
        try{
            ReturnDataFormat resultDate = ResultUtils.requestSuccess();
            long updates = cityService.deleteCity(id);
            LOGGER.info("影响行数："+updates);
            resultDate.setData("删除数据成功！");
            return resultDate;
        }catch (Exception e){
            return ResultUtils.requestErro(e);
        }
    }
}
