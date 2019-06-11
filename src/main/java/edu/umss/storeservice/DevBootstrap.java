/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap/* implements ApplicationListener<ContextRefreshedEvent>*/ {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

    }
}
